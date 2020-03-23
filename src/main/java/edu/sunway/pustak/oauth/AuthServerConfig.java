package edu.sunway.pustak.oauth;

import edu.sunway.pustak.entity.OAuthClient;
import edu.sunway.pustak.entity.User;
import edu.sunway.pustak.enums.Role;
import edu.sunway.pustak.enums.UserStatus;
import edu.sunway.pustak.repositories.OAuthClientRepository;
import edu.sunway.pustak.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

/*    @Value("${user.oauth.clientId}")
    private String ClientID;
    @Value("${user.oauth.clientSecret}")
    private String ClientSecret;*/
    @Autowired
    private OAuthClientRepository oAuthClientRepository;
    @Autowired
    private UserRepository userRepository;

    private final DataSource dataSource;


    private final Environment env;

/*    @Value("${user.oauth.redirectUris}")
    private String RedirectURLs;*/

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthServerConfig(Environment env,PasswordEncoder passwordEncoder, @Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager,
                            DataSourceConfig datasourceConfig) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.env = env;
        this.dataSource = datasourceConfig.oauthDataSource();
    }

    @PostConstruct
    public void dataSourceInitializerCustom(){
        OAuthClient oAuthClient = new OAuthClient();
        oAuthClient.setClientId("TEMPCLIENTID");
        oAuthClient.setClientSecret(passwordEncoder.encode("TEMPCLIENTSECRET"));
        oAuthClient.setScope("read,write");
        oAuthClient.setAuthorizedGrantTypes("password,authorization_code,refresh_token");
        oAuthClient.setAccessTokenValidity("25000");
        oAuthClient.setRefreshTokenValidity("40000");
        oAuthClient.setAutoapprove(true);
        oAuthClientRepository.save(oAuthClient);

        User user = userRepository.findByUsername("admin");
        if(user==null)
        {
            user = new User();
            user.setName("admin");
            user.setRole(Role.ADMIN);
            user.setUserName("admin");
            user.setStatus(UserStatus.ACTIVE);
            user.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(user);
        }

    }

    @Bean
    public DataSourceInitializer dataSourceInitializer() throws IOException {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        return initializer;
    }

    @Override
    public void configure(
            AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }


    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager);
    }

    private TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
/*        clients.inMemory()
                .withClient(ClientID)
                .secret(passwordEncoder.encode(ClientSecret))
                .authorizedGrantTypes("authorization_code","CLIENT_DETAILS","password", "refresh_token")
                .scopes("user_info")
                .autoApprove(true);
//                .redirectUris(RedirectURLs);*/
    }
}
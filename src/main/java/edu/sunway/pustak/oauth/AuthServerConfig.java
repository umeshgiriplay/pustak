package edu.sunway.pustak.oauth;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${user.oauth.clientId}")
    private String ClientID;
    @Value("${user.oauth.clientSecret}")
    private String ClientSecret;
    @Value("${user.oauth.redirectUris}")
    private String RedirectURLs;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthServerConfig(PasswordEncoder passwordEncoder, @Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(
            AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }


    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints){
        endpoints.authenticationManager(authenticationManager);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(ClientID)
                .secret(passwordEncoder.encode(ClientSecret))
                .authorizedGrantTypes("authorization_code","CLIENT_DETAILS","password", "refresh_token")
                .scopes("user_info")
                .autoApprove(true)
                .redirectUris(RedirectURLs);
    }
}
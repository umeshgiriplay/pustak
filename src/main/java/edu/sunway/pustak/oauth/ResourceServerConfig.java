package edu.sunway.pustak.oauth;


import edu.sunway.pustak.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@PropertySource("classpath:oauth.properties")
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final UserRepository userRepository;

    @Autowired
    public ResourceServerConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

/*

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    private UserDetailsService userDetailsService() {
        return new KhanePaniUserDetailsService(userRepository);
    }
*/

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/v1/user/").hasRole("USER")
                .antMatchers("/api/v1/admin/").hasRole("ADMIN")
                .anyRequest().permitAll();
    }

}

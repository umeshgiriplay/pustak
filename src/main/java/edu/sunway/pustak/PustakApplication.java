package edu.sunway.pustak;

import edu.sunway.pustak.entity.User;
import edu.sunway.pustak.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableResourceServer
@ComponentScan("edu.sunway")
@EnableJpaRepositories("edu.sunway.pustak.repositories")
public class PustakApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(PustakApplication.class, args);
    }

/*    @Override
    public void run(String... args) throws Exception {
        logger.info("All users  -> {}", userRepository.findAll());
    }*/
}
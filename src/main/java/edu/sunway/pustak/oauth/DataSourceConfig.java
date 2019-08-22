package edu.sunway.pustak.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Objects;

@PropertySource("classpath:oauth.properties")
@Configuration
public class DataSourceConfig {
    private final Environment env;

    @Autowired
    public DataSourceConfig(Environment env)
    {
        this.env = env;
    }

    public DataSource oauthDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(Objects.requireNonNull(env.getProperty("oauth.datasource.driverClassName")));
        dataSourceBuilder.url(Objects.requireNonNull(env.getProperty("oauth.datasource.url")));
        dataSourceBuilder.username(Objects.requireNonNull(env.getProperty("oauth.datasource.username")));
        dataSourceBuilder.password(Objects.requireNonNull(env.getProperty("oauth.datasource.password")));
        return dataSourceBuilder.build();
    }
}

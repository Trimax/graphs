package com.graphs.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCPConfiguration {
    @Value("${com.graphs.database.driver}")
    private String driver;

    @Value("${com.graphs.database.host}")
    private String host;

    @Value("${com.graphs.database.port}")
    private Integer port;

    @Value("${com.graphs.database.name}")
    private String database;

    @Value("${com.graphs.database.user}")
    private String user;

    @Value("${com.graphs.database.pass}")
    private String password;

    @Value("${com.graphs.database.maximalPoolSize}")
    private Integer maximalPoolSize;

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        final HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=yes&characterEncoding=UTF-8");
        configuration.setDriverClassName(driver);
        configuration.setUsername(user);
        configuration.setPassword(password);
        configuration.setMaximumPoolSize(maximalPoolSize);

        return new HikariDataSource(configuration);
    }
}

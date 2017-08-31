package com.graphs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
@PropertySource(value = "classpath:application.properties")
@ImportResource(value = "classpath:*.xml")
@MapperScan("com.graphs.mappers")
@ComponentScan("com.graphs.*")
public class Application extends SpringBootServletInitializer {
    public static void main(final String[] arguments) throws Exception {
        final SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationPidFileWriter("application.pid"));
        application.run();
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}

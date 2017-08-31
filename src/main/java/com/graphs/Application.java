package com.graphs;

import com.graphs.entities.UserEntity;
import com.graphs.mappers.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
@PropertySource(value = "classpath:application.properties")
@ImportResource(value = "classpath:*.xml")
@MapperScan("com.graphs.mappers")
@ComponentScan("com.graphs.*")
public class Application extends SpringBootServletInitializer {

    //TODO: Lombock
    @Autowired
    private UserMapper userMapper;

    public static void main(final String[] arguments) throws Exception {
        final SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationPidFileWriter("application.pid"));
        application.run();
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


    //TODO: Remove
    @PostConstruct
    public void init() {
        UserEntity user = userMapper.get(1L);
        System.out.printf("%d %s%n", user.id, user.eMail);
    }
}

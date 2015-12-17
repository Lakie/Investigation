package com.unesasoft.spring;

import com.unesasoft.persistance.dao.UserRepository;
import com.unesasoft.persistance.dao.impl.UserRepositoryImpl;
import com.unesasoft.persistance.dto.UserDTO;
import com.unesasoft.service.IUserService;
import com.unesasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Properties;

/**
 * Created by Slavyanin on 27.07.2015.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.unesasoft"  })
@PropertySource("classpath:email.properties")
public class AppConfig {
    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;
    @PersistenceContext
    EntityManager entityManager;

    // beans

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JavaMailSenderImpl javaMailSenderImpl() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost(env.getProperty("smtp.host"));
        mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
        mailSenderImpl.setProtocol(env.getProperty("smtp.protocol"));
        mailSenderImpl.setUsername(env.getProperty("smtp.username"));
        mailSenderImpl.setPassword(env.getProperty("smtp.password"));
        Properties javaMailProps = new Properties();
        javaMailProps.put("mail.smtp.auth", true);
        javaMailProps.put("mail.smtp.starttls.enable", true);
        mailSenderImpl.setJavaMailProperties(javaMailProps);
        return mailSenderImpl;
    }

    //repositories
    @Bean
    public IUserService iUserService(){
        return userService;
    }
    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryImpl(UserDTO.class, entityManager);
    }
}

package com.apricotforest.casefolder;

import net.paoding.rose.jade.context.spring.JadeBeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@ServletComponentScan
@SpringBootApplication
@ImportResource("classpath*:dubbo.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Spring Boot start...");
    }

    @Bean
    public JadeBeanFactoryPostProcessor jadeBeanFactory() {
        return new JadeBeanFactoryPostProcessor();
    }
}

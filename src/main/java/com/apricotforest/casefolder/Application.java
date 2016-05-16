package com.apricotforest.casefolder;

import net.paoding.rose.jade.context.spring.JadeBeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Boot提供的ErrorController是一种全局性的容错机制。你还可以使用SpringMVC提供的@ControllerAdvice。
 * 如字面意思，@ControllerAdvice是切面技术的应用，允许你对Controller中抛出的某个或某些异常进行捕获并响应输出.
 * 使用@ControllerAdvice捕获应用级别的异常，使用web.xml中的error-page配置处理容器级别的报错。假设定义的过滤器抛出的异常，
 * @ControllerAdvice是无法处理的。改用Spring Boot后，@ControllerAdvice没有捕获的异常，ErrorController会帮你“捡起来”
 */


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

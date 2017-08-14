package com.bonc.core.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Created by doraemon on 5/20/2017.
 * Spring boot web 应用实现类
 */
@SpringBootApplication //这个注解一口气添加了很多有用的注解，比如@EnableAutoConfiguration，ComponentScan等等
@ComponentScan("com.bonc.core")
public class Application extends SpringBootServletInitializer {
    /**
     * 将spring boot 应用的实现类指定为自己
     *
     * @param builder {@link SpringApplicationBuilder} 设置Spring 应用程序实现类的builder
     * @return {@link SpringApplicationBuilder} 设置了实现类为Application的builder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    /**
     * 强制将请求和回应的编码都设置为utf-8
     *
     * @return {@link CharacterEncodingFilter} 一个已经设置了字符集编码的过滤器
     */
    @Bean
    public Filter forceEncoding() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}

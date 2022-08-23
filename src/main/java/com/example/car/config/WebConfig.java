package com.example.car.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

   /* @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addFormatter(categoryFormatter());
    }

    @Bean
    public CategoryFormatter categoryFormatter() {
        return new CategoryFormatter();
    }*/

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/", "classpath:/resources/",
                        "classpath:/public/");
    }
}

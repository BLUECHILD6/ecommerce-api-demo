package com.example.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DevCorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")     // allow all origins (dev only)
            .allowedMethods("*")     // GET, POST, PUT, DELETE, ...
            .allowedHeaders("*")
            .exposedHeaders("*")
            .allowCredentials(false) // cannot be true with "*" origins
            .maxAge(3600);
    }
}

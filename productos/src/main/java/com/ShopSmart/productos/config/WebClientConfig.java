package com.ShopSmart.productos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient categoriaClient(){
        return WebClient.builder().baseUrl("http://localhost:8082/api/v1").build();
    }

}

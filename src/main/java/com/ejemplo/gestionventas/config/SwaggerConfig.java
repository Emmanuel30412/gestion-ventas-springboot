package com.ejemplo.gestionventas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
           .info(new Info()
            .title("Gestion de Venta API")
            .version("1.0")
            .description("Proyecto de ejemplo para gestion de ventas con Springboot")
            .contact(new Contact()
                  .name("Emmanuel Martinez")
                  .email("em62826@gmail.com")
                  .url("https://github.com/Emmanuel30412/gestion-ventas-springboot")));
    }
}

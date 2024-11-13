package co.com.cmdb.generales.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.com.cmdb.generales.application.secondaryports.repository"})
@EntityScan(basePackages = {"co.com.cmdb.generales.application.secondaryports.entity"})
@ComponentScan(basePackages = {"co.com.cmdb.generales"})
public class CmdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmdbApplication.class, args);
    }

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Cambiado a "**" para permitir todas las rutas
                        .allowedOrigins("https://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                        .allowedHeaders("*")  // Permitir todos los headers
                        .allowCredentials(true);
            }
        };
    }
}

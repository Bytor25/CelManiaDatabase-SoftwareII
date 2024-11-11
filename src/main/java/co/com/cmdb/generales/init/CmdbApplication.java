package co.com.cmdb.generales.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.com.cmdb.generales.application.secondaryports.repository"})
@EntityScan(basePackages = {"co.com.cmdb.generales.application.secondaryports.entity"})
@ComponentScan(basePackages = {"co.com.cmdb.generales"})
public class CmdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmdbApplication.class, args);
	}

}

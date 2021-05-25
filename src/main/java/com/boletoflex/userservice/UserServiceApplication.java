package com.boletoflex.userservice;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.boletoflex.userservice")
@EntityScan("com.boletoflex.userservice")
@EnableJpaRepositories("com.boletoflex.userservice")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2)
	        .select() 
	        .build() 
	        .pathMapping("/") 
	        .directModelSubstitute(LocalDate.class, String.class) 
	        .genericModelSubstitutes(ResponseEntity.class)
	        .useDefaultResponseMessages(false); 
	}
	
	@Bean
    public ResourceBundleMessageSource messageSource() {
        final ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setBasename("messages/messages");
        return resourceBundleMessageSource;
    }


}

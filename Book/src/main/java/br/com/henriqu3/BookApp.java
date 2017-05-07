package br.com.henriqu3;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class BookApp {

	public static void main(String[] args) {		
		SpringApplication.run(BookApp.class, args);
	}
	
	@Bean
	public Docket simpleDiffServiceApi() {
	  return new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo())
	            .select()
	            .apis( customRequestHandlers() )
	            .paths(Predicates.not(PathSelectors.regex("/error"))) // Exclude Spring error controllers
	            .build();
	 
	}
	
	private ApiInfo apiInfo() {
		  return new ApiInfoBuilder()
		  .title("A bookstore service")
		  .description("A bookstore REST service made with Spring Boot in Java")
		  .contact(new Contact("Henrique Nascimento", "", "henriqu3@gmail.com"))
		  .version("1.0")
		  .build();
		}
	
	private Predicate<RequestHandler> customRequestHandlers() {     
	    return new Predicate<RequestHandler>() {
	        @Override
	        public boolean apply(RequestHandler input) {
	            Set<RequestMethod> methods = input.supportedMethods();
	            return methods.contains(RequestMethod.GET);
	        }
	    };
	}
}

package com.crxmarkets.rainyhills.swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class Contains Swagger Configuration and info
 * @author AhmedTaha
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.crxmarkets.rainyhills.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Rainy Hills Volume Water Count")
                .description("This is application for calculate the numbers of volume of given input of hills")
                .version("1.0.0")
                .license("private")
				.termsOfServiceUrl("Terms of service refer to  crxmarkets")
                .contact(new Contact("Ahmed Taha", "https://www.crxmarkets.com/en/", "eng.ahmedtahaa@gmail.com"))
                .build();
    }
	
}

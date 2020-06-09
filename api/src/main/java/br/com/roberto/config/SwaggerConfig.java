package br.com.roberto.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.roberto")).paths(PathSelectors.any()).build()
				.apiInfo(metaInfo());

	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("API Rest", "Api Rest", "1.0", "Terms of Services",
				new springfox.documentation.service.Contact("Roberto", "https://github.com/robertoangelodasilvaramos", "sdinformatia@gmail.com"),
				"Apache Lincense version 1.0", "https://www.apache.org/licensen.html",
				new ArrayList<VendorExtension>());

		return apiInfo;
	}

}

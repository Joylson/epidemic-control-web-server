package br.com.epidemic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket detalheApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.select().apis(RequestHandlerSelectors.basePackage("br.com.epidemic.resource")).paths(PathSelectors.ant("/api/**"))
				.build().apiInfo(this.informacoesApi());

		return docket;
	}

	private ApiInfo informacoesApi() {

		return new ApiInfoBuilder().title("Web Service Epidemic Control")
				.description("Api para realização de um CRUD controle Epidemico.").version("1.0")
				.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.").license("Licença - Open Source")
				.licenseUrl("http://www.ciceroednilson.com.br").build();
	}

}

package erpservice.alexandre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
// import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("erpservice.alexandre")) // caminho do pacote
                .paths(PathSelectors.any()) // caminho dos endpoints
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Protótipo de Sistema Gerencial de Produtos")
                .description(
                        "Esta API fornece uma interface para gerenciar produtos, vendas e clientes. A API é destinada a desenvolvedores. A API inclui endpoints para criar, ler, atualizar e excluir produtos, vendas e clientes.")
                .version("1.0")
                // .termsOfServiceUrl("https://www.exemplo.com/terms")
                // .license("MIT")
                // .licenseUrl("https://www.exemplo.com/license")
                .build();
    }
}

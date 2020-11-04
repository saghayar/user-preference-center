package com.tgtech.preferencecenter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@OpenAPIDefinition(info =
@Info(title = "Fetch Preferences API", version = "1.0", description = "Documentation Fetch Preferences API v1.0")
)
public class FetchPreferencesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FetchPreferencesApplication.class, args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0")
                        .title("Fetch Preferences API")
                        .description("Documentation Fetch Preferences  API v1.0")
                        .build());
    }
}

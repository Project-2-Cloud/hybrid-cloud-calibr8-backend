package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;


@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("all")
                .apiInfo(apiInfo()).select().paths(any()).build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Factorio Rental Service API")
                .description("Factorio Rental Service for developers").version("1.0").build();
    }

}

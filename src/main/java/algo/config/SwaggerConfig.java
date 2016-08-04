package algo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("algo.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .enableUrlTemplating(false)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Algorithm Implementations REST API",
                "This API offers a way to visualise different Algorithm implementation performances. <br>" +
                        "It provides the logic to request performance reports on the fly, as well as the " +
                        "capabilities to save and retrieve them.",
                "0.0.1",
                "API TOS",
                contact(),
                "The MIT License (MIT)",
                "https://opensource.org/licenses/MIT"
        );
    }

    private Contact contact() {
        return new Contact(
                "Xavier CARON",
                "http://au.linkedin.com/in/xavierwilfriddimitrycaron",
                "xavier.w.caron@gmail.com"
        );
    }
}

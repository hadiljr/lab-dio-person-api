package lab.hadil.dio.person.restAPI.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
    }

    private static final Contact DEFAULT_CONTACT = new Contact("Hadil Aparecido dos Santos Junior",
                                                                "https://www.linkedin.com/in/hadil-junior-6158938/",
                                                                "hadiljr@gmail.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Lab DIO - Rest API Java/Cloud",
            "Api de veiculos com princípios de DDD",
            "1.0",
            null,
            DEFAULT_CONTACT,
            "GNU General Public License v3.0",
            "https://www.gnu.org/licenses/gpl-3.0.en.html",
            Collections.emptyList());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
            Arrays.asList("application/json", "application/xml")
    );
}

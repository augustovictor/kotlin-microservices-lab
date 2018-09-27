package augustovictor.com.github.kotlinmicroserviceslab

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    private final val DEFAULT_CONTACT = Contact("", "", "")
    private final val DEFAULT_API_INFO = ApiInfo("My API!", "Customized Api description", "1.0", "http://terms-of-service-url.com", "Victor Augusto", "urn:tos", "http://license-url.com")

    private val DEFAULT_PRODUCES_AND_CONSUMES = hashSetOf<String>("application/json", "application/xml")

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
    }
}
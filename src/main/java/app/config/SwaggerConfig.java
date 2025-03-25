package app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        Info applicationInfo = new Info()
                .title("Notification REST API")
                .description("REST API Designed to operate with user notifications.")
                .version("1.0")
                .contact(new Contact()
                        .name("Viktor Aleksandrov")
                        .email("viktor.aleksandrov@gmail.com")
                        .url("http://localhost:8081"))
                .license(new License()
                        .name("MIT License")
                        .url("https://opensource.org/licenses/MIT"));

        return new OpenAPI().info(applicationInfo);
    }
}

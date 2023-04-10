package com.binar.springboot.crud_rest_task.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;


//@Configuration
//@EnableSwagger2
public class OpenAPIConfig {
//    @Value("${binar.openapi.dev-url}")
    private String devUrl;

//    @Value("${binar.openapi.prod-url}")
    private String prodUrl;
//    @Bean
    public OpenAPI myOpenApi(){
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setName("Group One");
        contact.setUrl("https://www.groupone.com");
        contact.setEmail("groupone@gmail.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.groupone.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer,prodServer));

    }


    /*@Bean
    public Docket postApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()::test).build();
    }

    private Predicate<String> postPaths(){
        return regex("api/film/.*")::apply;
    }

    private ApiInfo apiInfo() {
        var url= "http://localhost:8080/film";
        return new ApiInfoBuilder().title("Film API Documentation")
                .description("The film API documentation")
                .termsOfServiceUrl(url)
                .contact(new Contact("Group One", url,"groupone@gmail.com")).license("Group License")
                .licenseUrl(url)
                .version("1.0")
                .build();
    }*/


}

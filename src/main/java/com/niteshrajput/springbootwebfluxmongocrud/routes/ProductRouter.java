package com.niteshrajput.springbootwebfluxmongocrud.routes;

import com.niteshrajput.springbootwebfluxmongocrud.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductRouter {

    @Bean
    public RouterFunction<ServerResponse> productRoutes(ProductHandler handler) {
        return route(GET("/api/products"), handler::getAllProducts)
                .andRoute(GET("/api/products/{id}"), handler::getProductById)
                .andRoute(POST("/api/products"), handler::createProduct)
                .andRoute(PUT("/api/products/{id}"), handler::updateProduct)
                .andRoute(DELETE("/api/products/{id}"), handler::deleteProducts);
    }
}

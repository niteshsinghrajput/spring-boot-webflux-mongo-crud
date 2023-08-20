package com.niteshrajput.springbootwebfluxmongocrud.handlers;

import com.niteshrajput.springbootwebfluxmongocrud.models.Product;
import com.niteshrajput.springbootwebfluxmongocrud.repositories.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

    private final ProductRepository productRepository;

    public ProductHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<ServerResponse> getAllProducts(ServerRequest request) {
        return ServerResponse.ok().body(productRepository.findAll(), Product.class);
    }

    public Mono<ServerResponse> getProductById(ServerRequest request) {
        String productId = request.pathVariable("id");
        return productRepository.findById(productId)
                .flatMap(product -> ServerResponse.ok().bodyValue(product))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createProduct(ServerRequest request) {
        Mono<Product> productMono = request.bodyToMono(Product.class);
        return productMono.flatMap(product -> productRepository.save(product))
                .flatMap(createProduct -> ServerResponse.ok().bodyValue(createProduct));
    }

    public Mono<ServerResponse> updateProduct(ServerRequest request) {
        String productId = request.pathVariable("id");
        Mono<Product> updatedProductMono = request.bodyToMono(Product.class);
        return productRepository.findById(productId)
                .flatMap(existingProduct -> updatedProductMono.flatMap(updatedProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    return productRepository.save(existingProduct);
                }))
                .flatMap(updatedProduct -> ServerResponse.ok().bodyValue(updatedProduct))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteProducts(ServerRequest request) {
        String productId = request.pathVariable("id");
        return productRepository.findById(productId)
                .flatMap(existingProduct ->
                        productRepository.delete(existingProduct)
                                .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}

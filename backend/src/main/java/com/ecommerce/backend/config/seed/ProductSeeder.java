package com.ecommerce.backend.config.seed;

import com.ecommerce.backend.dtos.product.DummyProductsResponse;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.ProductMapper;
import com.ecommerce.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;



@Component
@RequiredArgsConstructor
public class ProductSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final RestClient restClient;

    private static final String DUMMY_URL = "https://dummyjson.com/products?limit=194";

    // Irá preencher o banco de dados com os produtos da api
    // São 194 produtos
    @Override
    public void run(String... args) {
        System.out.println("Iniciando.");
        if (productRepository.count() > 0) {
            System.out.println("Produtos já existentes, seed ignorado.");
            return;
        }

        DummyProductsResponse response = restClient.get()
                .uri(DUMMY_URL)
                .retrieve()
                .body(DummyProductsResponse.class);

        if (response == null || response.products() == null) {
            System.out.println("Falha ao buscar produtos da DummyJSON.");
            return;
        }

        for (var dto : response.products()) {
            Product produto = ProductMapper.toEntity(dto);
            productRepository.save(produto);
        }

        System.out.println("Seed concluído: " + response.products().size() + " produtos inseridos.");
    }
}


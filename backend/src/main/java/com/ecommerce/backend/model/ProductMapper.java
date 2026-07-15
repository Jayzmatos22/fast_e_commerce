package com.ecommerce.backend.model;

import com.ecommerce.backend.dtos.DummyProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product toEntity(DummyProduct dto) {
        Product product = new Product();
        product.setDummyId(dto.id());
        product.setSku(dto.sku());
        product.setTitulo(dto.title());
        product.setDescricao(dto.description());
        product.setCategoria(dto.category());
        product.setMarca(dto.brand());
        product.setPreco(dto.price());
        product.setPercentualDesconto(dto.discountPercentage());
        product.setAvaliacao(dto.rating());
        product.setEstoque(dto.stock());
        product.setPeso(dto.weight());
        product.setInformacoesGarantia(dto.warrantyInformation());
        product.setInformacoesEnvio(dto.shippingInformation());
        product.setStatusDisponibilidade(dto.availabilityStatus());
        product.setPoliticaDevolucao(dto.returnPolicy());
        product.setQuantidadeMinimaPedido(dto.minimumOrderQuantity());
        product.setTags(dto.tags());
        product.setThumbnailUrl(dto.thumbnail());

        if (dto.dimensions() != null) {
            product.setLargura(dto.dimensions().width());
            product.setAltura(dto.dimensions().height());
            product.setProfundidade(dto.dimensions().depth());
        }

        List<ProductImage> imagens = new ArrayList<>();
        List<String> urls = dto.images() != null && !dto.images().isEmpty()
                ? dto.images()
                : List.of(dto.thumbnail()); // garante ao menos 1 imagem mesmo se "images" vier vazio

        for (int i = 0; i < urls.size(); i++) {
            ProductImage imagem = new ProductImage();
            imagem.setProduto(product);
            imagem.setUrl(urls.get(i));
            imagem.setOrdem(i);
            imagens.add(imagem);
        }
        product.setImagens(imagens);

        return product;
    }
}

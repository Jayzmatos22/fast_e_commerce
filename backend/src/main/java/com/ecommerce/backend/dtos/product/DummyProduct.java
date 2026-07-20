package com.ecommerce.backend.dtos.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DummyProduct(
        Integer id,
        String title,
        String description,
        String category,
        BigDecimal price,
        BigDecimal discountPercentage,
        BigDecimal rating,
        Integer stock,
        List<String> tags,
        String brand,
        String sku,
        BigDecimal weight,
        DummyDimensions dimensions,
        String warrantyInformation,
        String shippingInformation,
        String availabilityStatus,
        String returnPolicy,
        Integer minimumOrderQuantity,
        List<String> images,
        String thumbnail
) {}

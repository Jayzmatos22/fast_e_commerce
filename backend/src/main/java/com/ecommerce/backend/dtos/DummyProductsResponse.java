package com.ecommerce.backend.dtos;

import java.util.List;

public record DummyProductsResponse(
        List<DummyProduct> products,
        Integer total,
        Integer skip,
        Integer limit
) {
}

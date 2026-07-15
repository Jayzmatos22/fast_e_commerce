package com.ecommerce.backend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DummyDimensions(
        BigDecimal width,
        BigDecimal height,
        BigDecimal depth
) {}

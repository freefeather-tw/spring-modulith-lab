package com.freefeather.modulith.product.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {

    private String name;

    private String description;

    private int price;
}

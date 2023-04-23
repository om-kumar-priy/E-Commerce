package com.OmBazar.OmBazar.RequestDTO;

import com.OmBazar.OmBazar.Enum.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {

    private int sellerId;

    private String productName;

    private int price;

    private int quantity;

    private ProductCategory productCategory;
}
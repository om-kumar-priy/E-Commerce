package com.OmBazar.OmBazar.Service;

import com.OmBazar.OmBazar.Enum.ProductCategory;
import com.OmBazar.OmBazar.Exception.SellerNotFoundException;
import com.OmBazar.OmBazar.Model.Product;
import com.OmBazar.OmBazar.Model.Seller;
import com.OmBazar.OmBazar.Repository.ProductRepository;
import com.OmBazar.OmBazar.Repository.SellerRepository;
import com.OmBazar.OmBazar.RequestDTO.ProductRequestDto;
import com.OmBazar.OmBazar.ResponseDTO.ProductResponseDto;
import com.OmBazar.OmBazar.convertor.ProductConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {

        Seller seller;

        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch(Exception e){
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        Product product = ProductConvertor.productRequestDtotoProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

        // saved the seller and product - parent and child
        sellerRepository.save(seller);

        // prepare response
        ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);
        return productResponseDto;
    }





    public List<ProductResponseDto> getProductsByCategory(ProductCategory productCategory){

        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        // prepare a list of response dtos
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}
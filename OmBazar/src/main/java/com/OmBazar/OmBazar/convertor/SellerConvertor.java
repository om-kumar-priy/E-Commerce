package com.OmBazar.OmBazar.convertor;

import com.OmBazar.OmBazar.Model.Seller;
import com.OmBazar.OmBazar.RequestDTO.SellerRequestDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;


public class SellerConvertor {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
}
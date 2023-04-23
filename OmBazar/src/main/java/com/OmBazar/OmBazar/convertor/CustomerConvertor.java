package com.OmBazar.OmBazar.convertor;

import com.OmBazar.OmBazar.Model.Customer;
import com.OmBazar.OmBazar.RequestDTO.CustomerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConvertor {

    public static Customer CustomerRequestDtoToCustomer( CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }
}
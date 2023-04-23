package com.OmBazar.OmBazar.Service;


import com.OmBazar.OmBazar.Model.Seller;
import com.OmBazar.OmBazar.Repository.SellerRepository;
import com.OmBazar.OmBazar.RequestDTO.SellerRequestDto;
import com.OmBazar.OmBazar.convertor.SellerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepo;

    public String addSeller(SellerRequestDto sellerRequestDto){

        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepo.save(seller);

        return "Congrats! Now you can sell on Chine Market !!!";
    }
}
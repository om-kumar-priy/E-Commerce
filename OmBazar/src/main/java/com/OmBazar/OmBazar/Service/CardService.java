package com.OmBazar.OmBazar.Service;

import com.OmBazar.OmBazar.Exception.CustomerNotFoundException;
import com.OmBazar.OmBazar.Model.Card;
import com.OmBazar.OmBazar.Model.Customer;
import com.OmBazar.OmBazar.Repository.CustomerRepository;
import com.OmBazar.OmBazar.RequestDTO.CardRequestDto;
import com.OmBazar.OmBazar.ResponseDTO.CardDto;
import com.OmBazar.OmBazar.ResponseDTO.CardResponseDto;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        Customer customer;
        try{
            customer =customerRepository.findById(cardRequestDto.getCustomerId()).get();

        }
        catch (Exception e){
            throw new CustomerNotFoundException("Invalid customer Id");
        }
        Card card= Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .customer(customer)
                .build();


        //add the card to current card list of customer
        customer.getCards().add(card);
        customerRepository.save(customer);

        //prepare response Dto
 CardResponseDto cardResponseDto=new CardResponseDto();
 cardResponseDto.setName(customer.getName());

 //convert every card to cardDto

        List<CardDto>cardDtoList =new ArrayList<>();
        for (Card card1: customer.getCards())
        {
            CardDto cardDto=new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());

            cardDtoList.add(cardDto);
        }

        cardResponseDto.setCards(cardDtoList);
        return cardResponseDto;

    }
}

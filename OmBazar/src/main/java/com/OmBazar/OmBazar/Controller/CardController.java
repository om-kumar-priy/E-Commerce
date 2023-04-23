package com.OmBazar.OmBazar.Controller;

import com.OmBazar.OmBazar.RequestDTO.CardRequestDto;
import com.OmBazar.OmBazar.ResponseDTO.CardResponseDto;
import com.OmBazar.OmBazar.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @PostMapping("/add")
    public CardResponseDto addCard ( @RequestBody  CardRequestDto cardRequestDto) {
        return  addCard(cardRequestDto);
    }
}

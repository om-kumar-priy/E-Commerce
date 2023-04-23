package com.OmBazar.OmBazar.Service;

import com.OmBazar.OmBazar.Model.Cart;
import com.OmBazar.OmBazar.Model.Customer;
import com.OmBazar.OmBazar.Repository.CustomerRepository;
import com.OmBazar.OmBazar.RequestDTO.CustomerRequestDto;
import com.OmBazar.OmBazar.convertor.CustomerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public String addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer= CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDto);


        //alocate card to custo
   Cart cart=new Cart();
   cart.setCartTotal(0);
   cart.setCustomer(customer);

   //set cart in customer
   customer.setCart(cart);

customerRepository.save(customer);
return "congrats !! Welcome to Om Bazaar";


    }
}

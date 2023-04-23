package com.OmBazar.OmBazar.Repository;

import com.OmBazar.OmBazar.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
}
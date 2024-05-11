package com.msvc.sales.repository;

import com.msvc.sales.models.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SalesRepository  extends MongoRepository <Sales, Long>{

    Sales findByBuyerId(String buyerId);

    List<Sales> findByGameId(String gameId);


    Sales findBySalesId(String id);

}

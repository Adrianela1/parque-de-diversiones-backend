package com.msvc.sales.repository;

import com.msvc.sales.model.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesRepository  extends MongoRepository <Sales, Long>{
}

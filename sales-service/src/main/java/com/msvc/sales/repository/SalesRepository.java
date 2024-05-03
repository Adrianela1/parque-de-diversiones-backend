package com.msvc.sales.repository;

import com.msvc.sales.model.SalesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesRepository  extends MongoRepository <SalesModel, Long>{
}

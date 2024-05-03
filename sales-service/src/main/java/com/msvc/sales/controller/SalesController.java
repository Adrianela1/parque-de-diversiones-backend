package com.msvc.sales.controller;


import com.msvc.sales.model.SalesModel;
import com.msvc.sales.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SalesModel> getAllSales(){
       salesRepository.findAll();

        return List.of();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createSale( @RequestBody SalesModel saleModel) {
        salesRepository.save(saleModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateSale(@RequestBody SalesModel saleModel) {
        salesRepository.updateSale(saleModel);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteSale(@RequestBody SalesModel saleModel) {
        salesRepository.delete(saleModel);
    }

}

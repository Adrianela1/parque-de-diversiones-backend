package com.msvc.sales.service;

import com.msvc.sales.model.Sales;
import com.msvc.sales.repository.SalesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SalesService {

    @Autowired
    private SalesRepository salesRepository;


    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales getSalesById(Long id) {
        return salesRepository.findById(id).orElse(null);
    }

    public Sales createSales(Sales sales) {
        return salesRepository.save(sales);
    }

    public Sales updateSales(Long id, Sales salesDetails) {
        Sales sales = salesRepository.findById(id).orElse(null);
        if (sales != null) {
            BeanUtils.copyProperties(salesDetails, sales, "id");
            return salesRepository.save(sales);
        }
        return null;
    }

    public void deleteSales(Long id) {
        salesRepository.deleteById(id);
    }
}


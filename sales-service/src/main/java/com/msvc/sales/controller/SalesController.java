package com.msvc.sales.controller;


import com.msvc.sales.model.Sales;
import com.msvc.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public ResponseEntity<List<Sales>> getAllUsers() {
        List<Sales> users = salesService.getAllSales();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getUserById(@PathVariable Long id) {
        Sales sales = salesService.getSalesById(id);
        if (sales != null) {
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Sales> createUser(@RequestBody Sales sales) {
        Sales createdSales = salesService.createSales(sales);
        return new ResponseEntity<>(createdSales, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateUser(@PathVariable Long id, @RequestBody Sales salesDetails) {
        Sales updatedSales = salesService.updateSales(id, salesDetails);
        if (updatedSales != null) {
            return new ResponseEntity<>(updatedSales, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        salesService.deleteSales(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
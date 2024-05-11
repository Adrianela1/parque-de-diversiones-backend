package com.msvc.sales.service;

import com.msvc.sales.models.Compradores;
import com.msvc.sales.models.Sales;
import com.msvc.sales.repository.SalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;


@Service
public class SalesService {

    private Logger logger = LoggerFactory.getLogger(SalesService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SalesRepository salesRepository;


    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales getSalesByIdSales(String id) {
        return salesRepository.findBySalesId(id);
    }

    public List<Sales> getSalesByIdGame(String gameId) {
        return salesRepository.findByGameId(gameId);
    }

    public Sales getSalesByIdBuyer(String buyerId) {
        Sales sales = salesRepository.findByBuyerId(buyerId);
        Compradores compradoresDelJuego = restTemplate.getForObject(
                "http://localhost:8081/api/compradores/id/" + sales.getBuyerId(),
                Compradores.class
        );
        logger.info("{}", compradoresDelJuego);
        sales.setCompradores(Collections.singletonList(compradoresDelJuego));
        return sales;
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


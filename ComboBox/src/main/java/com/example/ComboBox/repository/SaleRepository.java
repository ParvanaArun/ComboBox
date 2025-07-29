package com.example.ComboBox.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ComboBox.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	
	List<Sale> findAllByOrderBySaledateDesc();

	List<Sale> findBySaledateBetweenOrderBySaledateDesc(LocalDate from, LocalDate to);

	List<Sale> findBySaledateOrderBySaledateDesc(LocalDate saledate);

}

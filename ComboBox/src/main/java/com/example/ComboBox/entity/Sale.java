package com.example.ComboBox.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sales")
public class Sale {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long saleid;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="itemid")
	private Item item;
	
	private Double totalamount;
	private LocalDate saledate;
	public Long getSaleid() {
		return saleid;
	}
	public void setSaleid(Long saleid) {
		this.saleid = saleid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}
	public LocalDate getSaledate() {
		return saledate;
	}
	public void setSaledate(LocalDate saledate) {
		this.saledate = saledate;
	}
	
	
	
	
	
}

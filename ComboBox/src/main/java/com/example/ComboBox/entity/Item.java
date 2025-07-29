package com.example.ComboBox.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long itemid;
	private String itemname;
	private Double price;
	private Double tax;
	private Double discount;
	private LocalDate manufactdt;
	private LocalDate expdate;
	private LocalDate purchasedt;
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public LocalDate getManufactdt() {
		return manufactdt;
	}
	public void setManufactdt(LocalDate manufactdt) {
		this.manufactdt = manufactdt;
	}
	public LocalDate getExpdate() {
		return expdate;
	}
	public void setExpdate(LocalDate expdate) {
		this.expdate = expdate;
	}
	public LocalDate getPurchasedt() {
		return purchasedt;
	}
	public void setPurchasedt(LocalDate purchasedt) {
		this.purchasedt = purchasedt;
	}
	
}

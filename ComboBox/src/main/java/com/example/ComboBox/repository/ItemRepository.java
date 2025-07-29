package com.example.ComboBox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComboBox.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

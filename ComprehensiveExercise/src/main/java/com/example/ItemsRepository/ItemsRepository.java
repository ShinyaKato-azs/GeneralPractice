package com.example.ItemsRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vegetables.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}

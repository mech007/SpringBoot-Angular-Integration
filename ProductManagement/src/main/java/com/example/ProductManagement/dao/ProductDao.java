package com.example.ProductManagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ProductManagement.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer>{

}

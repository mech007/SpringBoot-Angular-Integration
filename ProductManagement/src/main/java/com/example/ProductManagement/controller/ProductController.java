package com.example.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductManagement.dao.ProductDao;
import com.example.ProductManagement.model.Product;

@RestController
@RequestMapping("/productmanagement")
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return productDao.save(product);
	}
	
	@GetMapping("/allproducts")
	public List<Product> getallProducts() {
		return (List<Product>) productDao.findAll();
	}
	
	@PutMapping("/updateproduct/{productId}")
	public Product updateProduct(@PathVariable("productId") int productId,@RequestBody Product product) {
		product.setProductId(productId);
		return productDao.save(product);
	}
	
	@DeleteMapping("/deleteproduct/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId,@RequestBody Product product) {
		productDao.deleteById(productId);
	}
}

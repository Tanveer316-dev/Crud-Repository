package com.excelr.service;

import java.util.List;

import com.excelr.entity.Product;


public interface ProductService {
	
	public String upsert(Product product);
	public List<Product> getAllProducts();
	public String deleteProduct(Integer id);
		
	

}

package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Product;
import com.excelr.repository.ProductRepository;

@Service
public class ServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public String upsert(Product product) {
		Integer pid= product.getId();
		Product save= productRepository.save(product);
		if(pid==null) {
			return "Record inserted";
		}
		else {
		return "Record updated";
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public String deleteProduct(Integer id) {
		productRepository.deleteById(id);
		return "Product deleted";
	}

	

}

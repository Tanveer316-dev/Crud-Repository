package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.excelr.entity.Product;
import com.excelr.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		String msg=productService.upsert(product);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@PutMapping("/products")
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		String msg=productService.upsert(product);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAll(){
		List<Product> allProducts=productService.getAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK	);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		String s=productService.deleteProduct(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
		
		
	}
	

}

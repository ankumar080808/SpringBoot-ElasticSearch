package com.anant.Springbootelasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anant.Springbootelasticsearch.Service.ProductService;
import com.anant.Springbootelasticsearch.entity.Product;

@RestController
@RequestMapping("/apis")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/insert")
	public Product insertProduct(@RequestBody Product product)
	{
		return productService.insertProduct(product);
	}
	
	@GetMapping("/findAll")
	public Iterable<Product> getProducts()
	{
		return productService.getProducts();
	}

}

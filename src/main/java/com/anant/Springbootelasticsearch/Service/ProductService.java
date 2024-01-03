package com.anant.Springbootelasticsearch.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anant.Springbootelasticsearch.entity.Product;
import com.anant.Springbootelasticsearch.entity.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public Product insertProduct(Product product)
	{
		return productRepo.save(product);
	}

	public Iterable<Product> getProducts()
	{
		return productRepo.findAll();
	}
	
	public Product updateProduct(Product product,int id)
	{
		Product pro1=productRepo.findById(id).get();
		pro1.setPrice(product.getPrice());
		
		return pro1;	
	}
	
	public void deleteProduct(int id)
	{
		productRepo.deleteById(id);
	
	}
}

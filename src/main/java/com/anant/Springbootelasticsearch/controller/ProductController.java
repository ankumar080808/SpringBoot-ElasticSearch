package com.anant.Springbootelasticsearch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anant.Springbootelasticsearch.Service.ElasticSearchService;
import com.anant.Springbootelasticsearch.Service.ProductService;
import com.anant.Springbootelasticsearch.entity.Product;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@RestController
@RequestMapping("/apis")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ElasticSearchService elasticSearchService;

	@PostMapping("/insert")
	public Product insertProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}

	@GetMapping("/findAll")
	public Iterable<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/matchAll")
	public String matchAll() throws IOException {
		SearchResponse<Map> searchResponse = elasticSearchService.matchAllServices();
		System.out.println(searchResponse.hits().hits().toString());
		return searchResponse.hits().hits().toString();
	}

	@GetMapping("/matchAllProducts")
	public List<Product> matchAllProducts() throws ElasticsearchException, IOException {
		SearchResponse<Product> searchResponse = elasticSearchService.matchAllProductServices();
		System.out.println(searchResponse.hits().hits().toString());
		List<Product> allProducts = new ArrayList<>();
		List<Hit<Product>> listOfHits = searchResponse.hits().hits();
		for (Hit<Product> pro : listOfHits) {
			allProducts.add(pro.source());

		}

		return allProducts;

	}
	
	@GetMapping("/matchAllProducts/{fieldValue}")
	public List<Product> matchAllProducts(@PathVariable String fieldValue) throws ElasticsearchException, IOException {
		SearchResponse<Product> searchResponse = elasticSearchService.matchAllProductServicesWithNameField(fieldValue);
		System.out.println(searchResponse.hits().hits().toString());
		List<Product> allProducts = new ArrayList<>();
		List<Hit<Product>> listOfHits = searchResponse.hits().hits();
		for (Hit<Product> pro : listOfHits) {
			allProducts.add(pro.source());

		}

		return allProducts;

	}


}

package com.anant.Springbootelasticsearch.entity.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.anant.Springbootelasticsearch.entity.Product;

public interface ProductRepo extends ElasticsearchRepository<Product,Integer> {

}

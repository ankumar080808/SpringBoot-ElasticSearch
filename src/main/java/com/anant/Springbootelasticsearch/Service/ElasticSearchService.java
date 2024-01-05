package com.anant.Springbootelasticsearch.Service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.function.Supplier;

import com.anant.Springbootelasticsearch.entity.Product;
import com.anant.Springbootelasticsearch.util.ElasticSearchUtil;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

@Service
public class ElasticSearchService {
	
	@Autowired
	private ElasticsearchClient elasticSearchClient;
	
	public SearchResponse<Map> matchAllServices() throws ElasticsearchException, IOException
	{
		Supplier<Query> supply=ElasticSearchUtil.supplierQuery();
		
		 SearchResponse<Map>  searchResponse = elasticSearchClient.search(s->s.query(supply.get()),Map.class);
		 System.out.println("elasticsearch query is "+supply.get().toString());
		 return searchResponse;
	}
	
	public SearchResponse<Product> matchAllProductServices() throws ElasticsearchException, IOException
	{
		Supplier<Query> supply=ElasticSearchUtil.supplierQuery();
		System.out.println("SupplierQuery without get is"+supply);
		System.out.println("SupplierQuery with get is"+supply.get());
		SearchResponse<Product> searchResponse= elasticSearchClient.search(s->s.index("productsss").query(supply.get()),Product.class);
		return searchResponse;
	}
	
	
	public SearchResponse<Product> matchAllProductServicesWithNameField(String fieldValue) throws ElasticsearchException, IOException
	{
		Supplier<Query> supply=ElasticSearchUtil.supplierWithNameField(fieldValue);
		SearchResponse<Product> searchResponse= elasticSearchClient.search(s->s.index("productsss").query(supply.get()),Product.class);
		return searchResponse;
	}
	
	

}

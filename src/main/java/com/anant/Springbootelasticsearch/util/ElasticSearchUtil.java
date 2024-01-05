package com.anant.Springbootelasticsearch.util;

import java.util.function.Supplier;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

public class ElasticSearchUtil {
	
	
	public static MatchAllQuery matchAllQuery()
	{
		var matchAllQuery=new MatchAllQuery.Builder();
		
		System.out.println("MatchALLQuery with Builder is"+matchAllQuery);
		
		return matchAllQuery.build();
	}

	public static Supplier<Query> supplierQuery()
	{
		Supplier<Query> supplier=()-> Query.of(q->q.matchAll(matchAllQuery()));
		System.out.println("SupplierQuery without get is"+supplier);
		System.out.println("SupplierQuery with get is"+supplier.get());
		System.out.println("SupplierQuery with get and to string is"+supplier.get().toString());
		
		return supplier;
	}
	
	public static MatchQuery matchQueryWithNameField(String fieldValue)
	{
		var matchQuery=new MatchQuery.Builder();
		System.out.println("MatchQuery with Builder is"+matchQuery);
		
		
		return matchQuery.field("name").query(fieldValue).build();
	}
	
	public static Supplier<Query> supplierWithNameField(String fieldValue)
	{
		Supplier<Query> supplier=()->Query.of(q->q.match(matchQueryWithNameField(fieldValue)));
		System.out.println("SupplierQuery without get is"+supplier);
		System.out.println("SupplierQuery with get is"+supplier.get());
		System.out.println("SupplierQuery with get and to string is"+supplier.get().toString());
		
		return supplier;
	}
}

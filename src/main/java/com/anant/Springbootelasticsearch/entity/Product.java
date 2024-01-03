package com.anant.Springbootelasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "productsss")
public class Product {
   private int id;
    private String name;
    private String description;

    private int quantity;

    private double price;
}
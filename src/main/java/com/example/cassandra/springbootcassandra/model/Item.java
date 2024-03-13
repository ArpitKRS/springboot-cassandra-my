package com.example.cassandra.springbootcassandra.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @PrimaryKey
    private int id;
    private String name;
    private String date;
    private String productSold;
    private String timeOfSale;
}

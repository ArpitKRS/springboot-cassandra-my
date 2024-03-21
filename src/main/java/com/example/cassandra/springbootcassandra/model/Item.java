package com.example.cassandra.springbootcassandra.model;

import java.util.UUID;

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
    private UUID id;
    private String name;
    private String date;
    private String productSold;
    private String timeOfSale;
}

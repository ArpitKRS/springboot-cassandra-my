package com.example.cassandra.springbootcassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.cassandra.springbootcassandra.model.Item;

public interface ItemRepository extends CassandraRepository<Item, Integer> {

}

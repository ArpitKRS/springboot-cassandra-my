package com.example.cassandra.springbootcassandra.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.cassandra.springbootcassandra.model.Item;
import com.example.cassandra.springbootcassandra.repository.ItemRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

@Component
public class CsvLoader implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void run(String... args) throws Exception {
        try ( // Use try-with-resources for automatic closing of resources
                InputStream inputStream = getClass().getResourceAsStream("/sales_data.csv"); // Load resource as
                                                                                             // InputStream
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) // Create BufferedReader
                                                                                               // from InputStreamReader
        ) {
            @SuppressWarnings("resource")
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT); // Use reader for parsing

            for (CSVRecord record : parser) {
                try {
                    UUID uuid = UUID.fromString(record.get(0)); // Parse UUID from first column
                    String name = record.get(1);
                    String productSold = record.get(2);
                    String timeOfSale = record.get(3);
                    String date = record.get(4);

                    Item item = new Item(uuid, name, date, productSold, timeOfSale);
                    itemRepository.save(item);
                } catch (IllegalArgumentException e) {
                    // Handle invalid UUID gracefully (e.g., log error, skip record)
                    System.err.println("Invalid UUID encountered: " + record.get(0));
                }
            }
        }
    }
}

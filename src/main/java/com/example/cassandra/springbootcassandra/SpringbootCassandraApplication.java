package com.example.cassandra.springbootcassandra;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.cassandra.springbootcassandra.util.CsvLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCassandraApplication implements CommandLineRunner {

	@Autowired
	private CsvLoader csvLoader; // Assuming CsvLoader is a Spring bean

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCassandraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Application startup logic (optional)
		csvLoader.run(args); // Call CsvLoader's run method
	}
}

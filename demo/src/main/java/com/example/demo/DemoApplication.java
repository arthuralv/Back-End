package com.example.demo;

import com.example.demo.models.Container;
import com.example.demo.models.ReaderToCSV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.demo.models")
@EnableJpaRepositories("com.example.demo.DAO")

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Container container = new Container();
		ReaderToCSV reader = new ReaderToCSV ();

		container.catchFileFromURL();
		reader.CSVReader();
	}
}

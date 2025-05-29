package com.gomesnewton.LiterAlura;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gomesnewton.LiterAlura.models.Work;
import com.gomesnewton.LiterAlura.repositories.WorkRepository;
import com.gomesnewton.LiterAlura.services.GutenDexApi;
import com.gomesnewton.LiterAlura.services.WorkService;
import com.gomesnewton.LiterAlura.services.WorkServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	WorkService workService;
	private final GutenDexApi gutenDexApi = GutenDexApi.getInstance();
	private final ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);

    }

	@Override
	public void run(String... args) throws Exception {

		try {
			String bookJson = """ 
					{
						"id": 132456,
						"title": "1984",
						"authors": [{"name":"Orwell, George", "birth_year": 1234, "death_year": 1234}],
						"download_count": 0
					}
					""";

			Work _1984 = objectMapper.readValue(bookJson, Work.class);
			System.out.println(_1984.getTitle());
			workService.saveWork(_1984);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}

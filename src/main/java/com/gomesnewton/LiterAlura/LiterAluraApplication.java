package com.gomesnewton.LiterAlura;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gomesnewton.LiterAlura.models.SearchWorks;
import com.gomesnewton.LiterAlura.models.Work;
import com.gomesnewton.LiterAlura.services.GutenDexApi;
import com.gomesnewton.LiterAlura.services.WorkService;
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

        SearchWorks search = objectMapper.readValue(GutenDexApi.getInstance().search("moby dick"), SearchWorks.class);
		search.getResults().forEach(w -> System.out.println(w.toString()));
    }
}

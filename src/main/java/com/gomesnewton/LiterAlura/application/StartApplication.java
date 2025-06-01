package com.gomesnewton.LiterAlura.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gomesnewton.LiterAlura.models.SearchWorks;
import com.gomesnewton.LiterAlura.resources.GutenDexApi;
import com.gomesnewton.LiterAlura.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class StartApplication {

    private WorkService workService;
    private GutenDexApi gutenDexApi;
    private Scanner scanner = new Scanner(System.in);

    public StartApplication(WorkService workService, GutenDexApi gutenDexApi) {
        this.workService = workService;
        this.gutenDexApi = gutenDexApi;
    }

    public void start() {
        displayStartMenu();
    }

    private void displayStartMenu() {
        String menu = """
				--------- MENU INICIAL---------
				
				    1. buscar livro pelo título
				    2. listar livros registrados
				    3. listar autores registrados
				    4. listar autores vivos em determinado ano
				    5. listar livros em um determinaod idioma
				    0. sair
				
				Escolha o número de sua opção:""";
        System.out.println(menu);
        int option = scanner.nextInt();
        selectFuntions(option);
    }



    private void selectFuntions(int opt) {
        switch (opt) {
            case 1 -> searchBooks();
            case 2 -> System.out.println("Procurar no banco de dados");
            default -> displayStartMenu();
        }
    }

    private void searchBooks()  {
        System.out.println("Insira o nome do livro que você deseja procurar:");
        String procura = scanner.next();
        SearchWorks search;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            search = objectMapper.readValue(gutenDexApi.search(procura), SearchWorks.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        search.displayResults();
        System.out.println("Informe o id do livro que você deseja registra:");
        String id = scanner.next();
        workService.saveWork(gutenDexApi.getBookById(id));
    }
}

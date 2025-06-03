package com.gomesnewton.LiterAlura.application;

import com.gomesnewton.LiterAlura.models.Person;
import com.gomesnewton.LiterAlura.models.SearchWorks;
import com.gomesnewton.LiterAlura.models.Work;
import com.gomesnewton.LiterAlura.resources.GutenDexApi;
import com.gomesnewton.LiterAlura.services.PersonService;
import com.gomesnewton.LiterAlura.services.WorkService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;

@Service
public class StartApplication {

    private final WorkService workService;
    private final PersonService personService;
    private final GutenDexApi gutenDexApi;
    private final Scanner scanner = new Scanner(System.in);

    public StartApplication(WorkService workService, PersonService personService, GutenDexApi gutenDexApi) {
        this.workService = workService;
        this.personService = personService;
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
        System.out.print(menu);
        int option = scanner.nextInt();
        selectFuntions(option);
    }



    private void selectFuntions(int opt) {
        switch (opt) {
            case 1 -> buscarLivrosPeloTitulo();
            case 2 -> listarLivrosRegistratos();
            case 3 -> listarAutoresRegistratos();
            case 4 -> listarAutoresVivosEmDeterminadoAno();
            default -> displayStartMenu();
        }
    }

    private void buscarLivrosPeloTitulo()  {
        System.out.println("Insira o nome do livro que você deseja procurar (0 para voltar):");
        String procura = scanner.next();
        if (procura.equals("0")) {
            displayStartMenu();
        } else {
            SearchWorks search = gutenDexApi.search(procura);
            search.displayResults();
            System.out.println("Informe o id do livro que você deseja registra:");
            String id = scanner.next();
            workService.saveWork(gutenDexApi.getBookById(id));
        }
        displayStartMenu();
    }

    private void listarLivrosRegistratos() {
        System.out.println("--------- Livros Registrados --------");
        workService.fetchWorkList().forEach(System.out::println);
        System.out.println("-------------------------------------");
        displayStartMenu();
    }

    private void listarAutoresRegistratos() {
        System.out.println("--------- Autores Registrados --------");
        workService.fetchWorkList().forEach(w -> System.out.println(w.getAuthors()));
        System.out.println("-------------------------------------");
        displayStartMenu();
    }

    private void listarAutoresVivosEmDeterminadoAno() {
        System.out.println("-------- Autores Vivos em Determinado Ano --------");
        System.out.print("Informe o ano: ");
        Integer anoProcura = scanner.nextInt();
        personService.findByBirthYearAndDeathYear(anoProcura).forEach(System.out::println);
//        for (Person person : personService.fetchPersonList()) {
//
//            if (person.getBirthYear() < anoProcura && person.getDeathYear() > anoProcura) {
//                System.out.println(person);
//            } else {
//                System.out.println("N/A");
//            }
//        }
        displayStartMenu();
    }

    private void listarLivrosEmDeterminadoIdioma() {
        System.out.println("-------- Autores Vivos em Determinado Ano --------");
        String opçoesIdioma = """
                1. Portugues;
                2. Espanhol
                3. Francês
                4. Inglês
                
                Selecione uma das opções:
                """;

        System.out.print(opçoesIdioma);
        int anoProcura = scanner.nextInt();
        switch (anoProcura) {
            case 1:
        }
    }

}

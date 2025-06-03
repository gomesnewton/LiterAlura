package com.gomesnewton.LiterAlura.application;

import com.gomesnewton.LiterAlura.models.SearchWorks;
import com.gomesnewton.LiterAlura.resources.GutenDexApi;
import com.gomesnewton.LiterAlura.services.PersonService;
import com.gomesnewton.LiterAlura.services.WorkService;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class LiterAlura {

    private final WorkService workService;
    private final PersonService personService;
    private final GutenDexApi gutenDexApi;
    private final Scanner scanner = new Scanner(System.in);

    public LiterAlura(WorkService workService, PersonService personService, GutenDexApi gutenDexApi) {
        this.workService = workService;
        this.personService = personService;
        this.gutenDexApi = gutenDexApi;
    }

    public void start() {
        boolean run = true;

        while (run) {
            displayStartMenu();
            String fn = scanner.nextLine();

            if (fn.equals("1")) buscarLivrosPeloTitulo();
            if (fn.equals("2")) listarLivrosRegistratos();
            if (fn.equals("3")) listarAutoresRegistratos();
            if (fn.equals("4")) listarAutoresVivosEmDeterminadoAno();
            if (fn.equals("5")) listarLivrosEmDeterminadoIdioma();
            if (fn.equals("0")) run = false;

        }
    }

    private void displayStartMenu() {
        String menu = """
				-------------- MENU INICIAL--------------------
				
				    1. buscar livro pelo título
				    2. listar livros registrados
				    3. listar autores registrados
				    4. listar autores vivos em determinado ano
				    5. listar livros em um determinaod idioma
				    0. sair

				-----------------------------------------------
				
				Escolha o número de sua opção:""";

        System.out.print(menu);
    }


    private void buscarLivrosPeloTitulo()  {

        System.out.print("Insira o nome do livro que você deseja procurar (0 para voltar):");
        String titulo = scanner.nextLine();

        SearchWorks search = gutenDexApi.search(titulo);
        search.displayResults();

        System.out.print("Informe o número do livro que você deseja registra:");
        int index = Integer.parseInt(scanner.nextLine());
        workService.saveWork(search.getWork(index));
    }

    private void listarLivrosRegistratos() {
        System.out.println("--------- Livros Registrados --------\n");
        workService.fetchWorkList().forEach(System.out::println);
        System.out.println("-------------------------------------");
    }

    private void listarAutoresRegistratos() {
        System.out.println("--------- Autores Registrados --------\n");
        workService.fetchWorkList().forEach(w -> System.out.println(w.getAuthors()));
        System.out.println("-------------------------------------");
    }

    private void listarAutoresVivosEmDeterminadoAno() {
        System.out.println("-------- Autores Vivos em Determinado Ano --------");
        System.out.print("Informe o ano: ");
        Integer anoProcura = Integer.parseInt(scanner.nextLine());
        personService.findByBirthYearAndDeathYear(anoProcura).forEach(System.out::println);
    }

    private void listarLivrosEmDeterminadoIdioma() {
        System.out.println("-------- Autores Vivos em Determinado Ano --------");
        String opcoesIdioma = """
                1. Portugues;
                2. Inglês
                3. Espanhol
                4. Francês
                
                Selecione uma das opções:
                """;

        System.out.print(opcoesIdioma);
        String idioma = scanner.nextLine();
        switch (idioma) {
            case "1" -> workService.findByLanguages("pt").forEach(System.out::println);
            case "2" -> workService.findByLanguages("en").forEach(System.out::println);
            case "3" -> workService.findByLanguages("es").forEach(System.out::println);
            case "4" -> workService.findByLanguages("fr").forEach(System.out::println);
        }
    }

} //fecha classe

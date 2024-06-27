//package com.aluracursos.screenmatch;
//
//import com.aluracursos.screenmatch.principal.Principal;
//import com.aluracursos.screenmatch.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ScreenmatchApplicationConsola implements CommandLineRunner {
//
//	@Autowired //Le estoy diciendo que quiero que haga intección de dependencias, desde la clase que Spring creó
//	private SerieRepository repository; //que voy a querer que "inyecte"
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenmatchApplicationConsola.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal(repository);
//		principal.muestraElMenu();
//
//	}
//}

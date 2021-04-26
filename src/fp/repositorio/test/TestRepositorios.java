package fp.repositorio.test;

import java.time.LocalDateTime;

import fp.repositorio.Language;
import fp.repositorio.Repositorio;
import fp.repositorio.Repositorios;

public class TestRepositorios {
	
	private static String[] arrString = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
			"programming", "math" };
	private static Repositorio repositorio1 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio2 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio3 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio4 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio5 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio6 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio7 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio8 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	private static Repositorio repositorio9 = new Repositorio("test1", "test2", "test3", LocalDateTime.now(),
			Language.CPLUSPLUS, 10000, arrString);
	
	private static Repositorios repositorios = new  Repositorios();
	
	public static void main(String[] args) {
		
		testConstructor();
		
	}
	
	private static void testConstructor() {
		
		System.out.println("\nTEST del Constructor");
		
		try {
			
			repositorios = new Repositorios();
			repositorios.addRepo(repositorio1);
			repositorios.addRepo(repositorio2);
			repositorios.addRepo(repositorio3);
			repositorios.addRepo(repositorio4);
			repositorios.addRepo(repositorio5);
			repositorios.addRepo(repositorio6);
			repositorios.addRepo(repositorio7);
			repositorios.addRepo(repositorio8);
			repositorios.addRepo(repositorio9);
			
			System.out.print(repositorio1);

			System.out.println("  REPOSITORIOS: "+ repositorios + "\n");
			
		} catch(Exception e) {
			
			System.out.println("Excepción capturada:\n   " + e);	
			
		}
		
	}

}

package fp.repositorio.test;

import java.time.LocalDateTime;
import java.util.Map;
import fp.repositorio.FactoriaRepositorios;
import fp.repositorio.Language;
import fp.repositorio.Repositorio;
import fp.repositorio.Repositorios;
import fp.utils.Utiles;


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

	private static Repositorios repositorios = new Repositorios();

	private static Repositorios repositorios2 = FactoriaRepositorios.reedRepos("data/TopStaredRepositories.csv");

	public static void main(String[] args) {

//		testConstructor();
//		testContador();
//		testGetRepositorysbyLanguage();
//		testGetAverageStarsbyLanguage();
//		testHaveStars();
//		testGetRepositoryLanguageByStars();
//		testGetfechasPrueba();
//		testExistRepoTagQuantityStars();
//		testExistRepoTagLanguage();
//		testGetLanguageDistintOfTag();
		testGetAverageStarsbyLanguageStream();
//		testGetAllTags();

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

			System.out.println("  REPOSITORIOS: " + repositorios + "\n");

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);

		}

	}

	private static void testContador() {

		try {

			String cadena = "JAVASCRIPT, CPLUSPLUS, JAVA, SHELL, HTML, C, CSS, COFFEESCRIPT, GO, RUBY, PYTHON, PHP, TYPESCRIPT, OBJECTIVEC,\n"
					+ "	ASSEMBLY, SWIFT, RUST, VIMSCRIPT, CLOJURE, LUA, RASCAL, SCALA, MATLAB, VUE, PERL,KOTLIN,NOPROLAN,POWERSHELL,PUREBASIC";

			String[] nombres = cadena.split(",");

			for (String nombre : nombres) {
				System.out.println("Numero de lenguanes " + nombre + ": " + repositorios2.contadorLenguajes(Language.valueOf(nombre.trim())));
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("Excepción capturada:\n   " + e);

		}

	}
	
	private static void testCalculaNombresUsuarios() {

		try {

			String cadena = "JAVASCRIPT, CPLUSPLUS, JAVA, SHELL, HTML, C, CSS, COFFEESCRIPT, GO, RUBY, PYTHON, PHP, TYPESCRIPT, OBJECTIVEC,\n"
					+ "	ASSEMBLY, SWIFT, RUST, VIMSCRIPT, CLOJURE, LUA, RASCAL, SCALA, MATLAB, VUE, PERL,KOTLIN,NOPROLAN,POWERSHELL,PUREBASIC";

			String[] nombres = cadena.split(",");

			for (String nombre : nombres) {
				System.out.println("Numero de lenguanes " + nombre + ": " + repositorios2.contadorLenguajes(Language.valueOf(nombre.trim())));
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("Excepción capturada:\n   " + e);

		}

	}
	
	private static void testGetRepositorysbyLanguage() {
		try {
			Map<Language,Integer> testMap = repositorios2.getRepositorysbyLanguage();
			Utiles.show(testMap);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testGetAverageStarsbyLanguage() {
		try {
			Map<Language,Double> testMap = repositorios2.getAverageStarsbyLanguage();
			Utiles.show(testMap);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	
	private static void testHaveStars() {
		try {
			
			System.out.print(repositorios2.haveStars(1000000));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	
//	private static void testGetRepositoryLanguageByStars() {
//		try {
//			System.out.print(b); 
//			repositorios2.getRepositoryLanguageByStars(Language.C));
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("Excepción capturada:\n   " + e);
//		}
//	}
	/**/
	
	private static void testGetfechasPrueba() {
		try {
			System.out.print(repositorios2.getfechasPrueba("web", Language.JAVASCRIPT,3));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	
	
	private static void testExistRepoTagQuantityStars() {
		try {
			System.out.print(repositorios2.existRepoTagQuantityStars("web",1));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	private static void testExistRepoTagLanguage() {
		try {
			
			System.out.print(repositorios2.existRepoTagLanguage("php", Language.PHP));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	
	private static void testGetLanguageDistintOfTag() {
		try {
			for (String tag : repositorios2.getAllTags()) {
				System.out.println(repositorios2.getLanguageDistintOfTag(tag));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	private static void testGetAverageStarsbyLanguageStream() {
		try {
			Utiles.show(repositorios2.getAverageStarsbyLanguageStream());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}
	
	private static void testGetAllTags() {
		try {
			System.out.print(repositorios2.getAllTags());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

}

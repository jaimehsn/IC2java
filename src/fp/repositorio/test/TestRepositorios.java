package fp.repositorio.test;

import java.time.LocalDateTime;
import java.util.List;
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

	private static Repositorios repositorios2 = FactoriaRepositorios.reedReposStream("data/TopStaredRepositories.csv");

	public static void main(String[] args) {

		testConstructorEmpty();
		testNumberOfLanguagesByTag();
		testGetRepositorysbyLanguage();
		testGetAverageStarsbyLanguage();
		testHaveStars();
		testGetRepositoryLanguageByStars();
		testGetNamesByTagLanguage();
		testExistRepoTagQuantityStars();
		testExistRepoTagLanguage();
		testGetLanguageDistintOfTag();
		testGetAverageStarsbyLanguageStream();
		testGetAllTags();
		testConstructorNormal();
		testConstructorSream();

	}

	private static void testConstructorEmpty() {

		System.out.println("\n************TEST del Constructor vacio************");

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

			System.out.println("  REPOSITORIOS: " + repositorios + "\n");

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);

		}

	}

	private static void testConstructorNormal() {
		System.out.println("\n\n\n************TEST que comprueba el funcinamiento del constructor habitual REPOSITORIO************");
		try {

			Repositorios repos = FactoriaRepositorios.reedRepos("data/TopStaredRepositories.csv");
			System.out.println("Repositoios extraidos de manera tradicional: \n\n" + repos.toString());

		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testConstructorSream() {
		System.out.println("\n\n\n************TEST que comprueba el funcionamiento del constructor con strem REPOSITORIO************");
		try {

			Repositorios repos = FactoriaRepositorios.reedReposStream("data/TopStaredRepositories.csv");
			System.out.println("Repositoios extraidos de manera tradicional: \n\n" + repos.toString());

		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testNumberOfLanguagesByTag() {
		System.out.println("\n\n\n************TEST que comprueba las salidas multiples del la funcion contadorLenguajes REPOSITORIO************");

		try {

			List<String> tags = repositorios2.getAllTags();

			for (String tag : tags) {
				System.out.println("Numero de lenguanes " + tag + ": " + repositorios2.counterLanguages(tag));
			}

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);

		}

	}

	private static void testGetRepositorysbyLanguage() {
		System.out.println("\n\n\n************TEST que comprueba la agrupoacion en un map de manera tradicional REPOSITORIO************");
		try {
			Map<Language, Integer> testMap = repositorios2.getRepositorysbyLanguage();
			Utiles.show(testMap);

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testGetAverageStarsbyLanguage() {
		System.out.println("\n\n\n************TEST que comprueba el funcinamiento de del metodo que obtiene la media por lenguaje REPOSITORIO************");
		try {
			Map<Language, Double> testMap = repositorios2.getAverageStarsbyLanguage();
			Utiles.show(testMap);

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testHaveStars() {
		System.out.println("\n\n\n************TEST que comprueba que la existencia de repositorios hechos con un lenguaje y umbral de sstrellas concreto REPOSITORIO************");
		try {

			System.out.println("Comprobacion del umbral: " + repositorios2.haveStars(100, Language.CSS));
			System.out.println("Comprobacion del umbral: " + repositorios2.haveStars(1000, Language.CSS));
			System.out.println("Comprobacion del umbral (false): " + repositorios2.haveStars(10000, Language.CSS));

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testGetRepositoryLanguageByStars() {
		System.out.println("\n\n\n************TEST que comprueba las salida de los repositoros agrupados por numero de estrellas REPOSITORIO************");
		try {
			System.out.print("Caso habitual: \n" + repositorios2.getRepositoryLanguageByStars(Language.PYTHON));

			System.out.print("Caso habitual: \n" + repositorios2.getRepositoryLanguageByStars(Language.NOPROLAN));

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testGetNamesByTagLanguage() {
		System.out.println("\n\n\n************TEST que comprueba todos lons nombres usando todas las tags REPOSITORIO************");
		try {
			List<String> tags = repositorios2.getAllTags();
			System.out.println("Nombres de repositorios:");

			for (String tag : tags) {
				System.out.println(repositorios2.getNamesByTagLanguage(tag, Language.JAVASCRIPT, 10));
			}

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testExistRepoTagQuantityStars() {
		System.out.println("\n\n\n************TEST que comprueba varios casos de existencia de repositorios con parametros de fecha, tag y strellas REPOSITORIO************");
		try {
			System.out.print("\n Test de coincidencia: " + repositorios2.existRepoTagQuantityStars("web", 1, 2017));
			System.out.print(
					"\n Test de coincidencia: " + repositorios2.existRepoTagQuantityStars("otroCosa", 100000, 2022));
			System.out.print("\n Test de coincidencia: " + repositorios2.existRepoTagQuantityStars("php", 1000, 2017));
			System.out.print("\n Test de coincidencia: " + repositorios2.existRepoTagQuantityStars("java", 1000, 2016));

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testExistRepoTagLanguage() {
		System.out.println("\n\n\n************TEST que comprueba la existencia de todas las tags en un lenguage en concreto  REPOSITORIO************");
		try {

			List<String> tags = repositorios2.getAllTags();
			System.out.println("Nombres de repositorios:");

			for (String tag : tags) {
				System.out.println(repositorios2.existRepoTagLanguage(tag, Language.PHP));
			}

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testGetLanguageDistintOfTag() {
		System.out.println("\n\n\n************TEST que comprueba la salidad de lenguajes de todos las tagas REPOSITORIO************");
		try {
			for (String tag : repositorios2.getAllTags()) {
				System.out.println(repositorios2.getLanguageDistintOfTag(tag));
			}

		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testGetAverageStarsbyLanguageStream() {
		System.out.println("\n\n\n************TEST comprueba la salidad de las medias del metodo getAverageStarsbyLanguageStream REPOSITORIO************");
		try {
			Utiles.show(repositorios2.getAverageStarsbyLanguageStream());
		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	private static void testGetAllTags() {
		System.out.println("\n\n\n************TEST comprueba que se obtiene todas las tagas que existen en le archivo csv REPOSITORIO************");
		try {
			System.out.print(repositorios2.getAllTags());
		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

}

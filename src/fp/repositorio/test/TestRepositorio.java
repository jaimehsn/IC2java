package fp.repositorio.test;

import java.time.LocalDateTime;
import fp.repositorio.Language;
import fp.repositorio.Repositorio;

public class TestRepositorio {

	public static void main(String[] args) {
		testConstructorEmpty();
		testConstructor();
		testConstructorString();
		testConstructorErrors();
		testObjectsEqual();
		testObjectsNotEqual();
		testObjectsConpare();
		testPropiedadesDerivURL();
		testObjectsClone();
	}

	public static void testConstructorEmpty() {
		System.out.println("\n************TEST del Constructor vacio************");
		try {

			Repositorio repositorio = new Repositorio();
			System.out.print("	REPO empty: \n" + repositorio);
			repositorio.setUsername("jaimehsn");
			repositorio.setRepoName("caroApp");
			repositorio.setDescription("Aplicaciones de gestion del trabajo de empleados.");
			repositorio.setStarsNumber(100);
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			repositorio.setTags(tags);

			System.out.print("	REPO filled: \n" + repositorio);

		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}

	}

	public static void testConstructor() {
		System.out.println("\n************TEST del Constructor************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			System.out.print("	REPO: " + repositorio);
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}

	}

	public static void testConstructorErrors() {
		System.out.println("\n\n************TEST del Constructor CON ERRORES************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, -100, tags);
			System.out.print("	REPO: " + repositorio);
		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	public static void testConstructorString() {
		System.out.println("\n\n\n************TEST del constructor que se le pasa como entrada una cadena REPOSITORIO************");
		try {
			Repositorio repositorio = new Repositorio(
					"freeCodeCamp,freeCodeCamp,The https://freeCodeCamp.com open source codebase and curriculum. Learn to code and help nonprofits.,2017-06-24 15:56:17,patata,29.5k,\"nonprofits/certification/curriculum/react/nodejs/javascript/d3/teachers/community/education/programming/math/learn-to-code/careers\",https://github.com/freeCodeCamp/freeCodeCamp");
			System.out.print(repositorio.toString());
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	public static void testPropiedadesDerivURL() {
		System.out.println("\n\n\n************TEST del las propiedades derivadas de la clase REPOSITORIO************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			System.out.print("	REPO URL: " + repositorio.getUrl());
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}

		

	}
	
	public static void testPropertiesDerivCODE() {
		System.out.println("\n\n\n************TEST del las propiedades de comparacion de las clase REPOSITORIO************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			System.out.print("	REPO CONTIENE CODIGO?: " + repositorio.getIsCode());
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	public static void testObjectsEqual() {
		System.out.println("\n\n\n************TEST del las propiedades de comparacion de las clase REPOSITORIO************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			Repositorio repositorio2 = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario",
					LocalDateTime.now(), Language.CPLUSPLUS, 10000, tags);
			System.out.print("	REPO EQUALS?: " + repositorio.equals(repositorio2));
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}

	}

	public static void testObjectsNotEqual() {
		System.out.println("\n\n\n************TEST que comprueba la igualdad entre objetos REPOSITORIO************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			Repositorio repositorio2 = new Repositorio("OtroCosa", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			System.out.print("	REPO EQUALS? (Cambio en un username): " + repositorio.equals(repositorio2));
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	public static void testObjectsConpare() {
		System.out.println("\n\n\n************TEST que comprueba el funcionamiento de la funciona compareTo REPOSITORIO************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			Repositorio repositorio2 = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario",
					LocalDateTime.now(), Language.CPLUSPLUS, 10000, tags);
			System.out.print("	REPO == ?(instancias distintas): " + (repositorio == repositorio2));
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	public static void testObjectsConpareNotEqual() {
		System.out.println("\n\n\n************TEST que comprueba el funcionamiento de la funcion compareTo REPOSITORIO************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			Repositorio repositorio2 = repositorio;
			System.out.print("	REPO == ?: " + (repositorio == repositorio2));
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

	public static void testObjectsClone() {
		System.out.println("\n\n\n************TEST que comprueba la modificacion de objetos mutables REPOSITORIO************");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			Repositorio repositorio2 = repositorio;
			System.out.print("Unmodified object:" + repositorio);
			repositorio2.setUsername("updatedName");
			System.out.print("\n\nModified object:" + repositorio);
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

}

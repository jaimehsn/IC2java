package fp.repositorio.test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import fp.repositorio.Language;
import fp.repositorio.Repositorio;

public class TestRepositorio {

	public static void main(String[] args) {
		testConstructor();

	}

	public static void testConstructor() {
		System.out.println("\nTEST del Constructor");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, 10000, tags);
			System.out.print("	REPO: " + repositorio);
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}

		System.out.println("\n\nTEST del Constructor CON ERRORES");
		try {
			String[] tags = { "react", "nodejs", "javascript", "d3", "teachers", "community", "education",
					"programming", "math" };
			Repositorio repositorio = new Repositorio("freeCodeCamp", "freeCodeCamp", "Comentario", LocalDateTime.now(),
					Language.CPLUSPLUS, -100, tags);
			System.out.print("	REPO: " + repositorio);
		} catch (Exception e) {

			System.out.println("Excepción capturada:\n   " + e);
		}
		
		try {
			Repositorio repositorio = new Repositorio(
					"freeCodeCamp,freeCodeCamp,The https://freeCodeCamp.com open source codebase and curriculum. Learn to code and help nonprofits.,2017-06-24 15:56:17,patata,29.5k,\"nonprofits,certification,curriculum,react,nodejs,javascript,d3,teachers,community,education,programming,math,learn-to-code,careers\",https://github.com/freeCodeCamp/freeCodeCamp");
			System.out.print(repositorio.toString());
		} catch (Exception e) {
			System.out.println("Excepción capturada:\n   " + e);
		}
	}

}

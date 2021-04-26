package fp.repositorio.test;

import fp.repositorio.FactoriaRepositorios;
import fp.repositorio.Repositorios;

public class TestFactoriaRepositorios {
	
	public static void main(String[] args) {
		testCreacionRepositorios();
	}

	private static void testCreacionRepositorios() {
		
		System.out.println("\nTEST de la creacion de repositorios");
		
		try {
			
			Repositorios repositorios = FactoriaRepositorios.reedRepos("data/TopStaredRepositories.csv");
			System.out.println("   REPOSITORIOS: "+ repositorios);
			
		} catch(Exception e) {
			
			System.out.println("Excepción capturada:\n   " + e);	
			
		}
		
	}

}

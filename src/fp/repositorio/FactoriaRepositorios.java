package fp.repositorio;

import java.util.List;

import fp.utils.Ficheros;

public class FactoriaRepositorios {
	
	/**
	 * @param str
	 * 		Variable de tipo Cadena, contiene la informacion de una linea del fichero .csv
	 * 		
	 * Metodo de clase que crea un objeto de tipo Repositorio.
	 *     
	 * @return repo
	 * 		Objeto de tipo Repositorio.
	 *  
	 */

	public static Repositorio parseRepo(String str) {

		Repositorio repo = new Repositorio(str);
		return repo;

	}
	
	/**
	 * @param path
	 * 		Variable de tipo cadena, Contiene la ruta del archivo .csv de donde extrae la informacion.
	 * 		
	 * 
	 * Metodo de clase que crea un objeto de tipo Repositorios e inserta en 
	 * el todos los objetos procedentes del fichero .csv, haciendo uso del metodo anterior parseRepo.
	 *     
	 * @return repositorios
	 * 		Debuelbe un objeto de la clase Repositorios.
	 *  
	 */

	public static Repositorios reedRepos(String path) {

		List<String> rows = Ficheros.leerFicheros(path);

		Repositorios repositorios = new Repositorios();

		for (String row : rows) {
			Repositorio repo = parseRepo(row);
			repositorios.addRepo(repo);
		}
		
		return repositorios;
		
	}

}

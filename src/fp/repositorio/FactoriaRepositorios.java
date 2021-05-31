package fp.repositorio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import fp.utils.Ficheros;

public class FactoriaRepositorios {

	/**
	 * @param str Variable de tipo Cadena, contiene la informacion de una linea del
	 *            fichero .csv
	 * 
	 *            Metodo de clase que crea un objeto de tipo Repositorio.
	 * 
	 * @return repo Objeto de tipo Repositorio.
	 * 
	 */

	public static Repositorio parseRepo(String str) {

		Repositorio repo = new Repositorio(str);
		return repo;

	}

	/**
	 * @param path Variable de tipo cadena, Contiene la ruta del archivo .csv de
	 *             donde extrae la informacion.
	 * 
	 * 
	 *             Metodo de clase que crea un objeto de tipo Repositorios e inserta
	 *             en el todos los objetos procedentes del fichero .csv, haciendo
	 *             uso del metodo anterior parseRepo.
	 * 
	 * @return repositorios Debuelbe un objeto de la clase Repositorios.
	 * 
	 */

//	public static Repositorios reedRepos(String path) {
//
//		List<String> rows = Ficheros.leerFicheros(path);
//
//		Repositorios repositorios = new Repositorios();
//
//		for (String row : rows) {
//			Repositorio repo = parseRepo(row);
//			repositorios.addRepo(repo);
//		}
//
//		return repositorios;
//
//	}
	public static Repositorios reedRepos(String path) {
		Repositorios res = null;
		try {
			Stream<Repositorio> Rp = Files.lines(Paths.get(path))
					.skip(1)
					.map(FactoriaRepositorios::parseRepo);
			res = new Repositorios(Rp);

		} catch (IOException e) {
			// TODO: handle exception
			System.out.print("File not found: " + path);
			e.printStackTrace();
		}

		return res;

	}

}

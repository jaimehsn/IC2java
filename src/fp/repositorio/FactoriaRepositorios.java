package fp.repositorio;

import java.util.List;

import fp.utils.Ficheros;

public class FactoriaRepositorios {

	public static Repositorio parseRepo(String str) {
		Repositorio repo = new Repositorio(str);
		return repo;
	}

	public static Repositorios reedRepos(String path) {

		List<String> rows = Ficheros.leerFicheros(path);
		Repositorios repositorios = new Repositorios();
		for (String row : rows) {
			System.out.println(row);
			Repositorio repo = parseRepo(row);
			repositorios.addRepo(repo);
		}
		return repositorios;
	}

}

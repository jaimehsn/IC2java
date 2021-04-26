package fp.repositorio;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repositorios {
	
	
	private Set<Repositorio> repositorios = null;
	
	/**
	 * Constructor que inicializa un Set de objetos unicos vacio
	 *  
	 */

	public Repositorios() {
		this.repositorios = new HashSet<Repositorio>();
	}
	
	/**
	 * @param Set de tipo Repositorio
	 * 
	 * Constructor que inicializa un Set de objetos de tipo Repositorio pasados por parametro.
	 *  
	 */

	public Repositorios(Set<Repositorio> repositorios) {
		this.repositorios = new HashSet<Repositorio>(repositorios);
	}
	
	/**
	 * @param Coleccion stream de tipo Repositorio
	 * 
	 * Contructo que inicializa un Set de objetor de tipo Repositorio haciendo uso de funciones
	 * de colecciones.    
	 *  
	 */

	public Repositorios(Stream<Repositorio> repo) {
		this.repositorios = repo.collect(Collectors.toSet());
	}
	
	/**
	 * @param Objeto de tipo Repositorio
	 * 
	 * Metodo de objeto que añade un elemento de tipo Repositorio al set.
	 *  
	 */

	public void addRepo(Repositorio repo) {
		this.repositorios.add(repo);
	}

}

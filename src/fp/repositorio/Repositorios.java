package fp.repositorio;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repositorios {

	private Set<Repositorio> repositorios = null;

	public Repositorios() {
		this.repositorios = new HashSet<Repositorio>();
	}

	public Repositorios(Set<Repositorio> repositorios) {
		this.repositorios = new HashSet<Repositorio>(repositorios);
	}

	public Repositorios(Stream<Repositorio> repo) {
		this.repositorios = repo.collect(Collectors.toSet());
	}

	public void addRepo(Repositorio repo) {
		this.repositorios.add(repo);
	}

}

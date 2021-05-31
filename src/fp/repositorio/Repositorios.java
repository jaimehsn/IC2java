package fp.repositorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
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
	 *            Constructor que inicializa un Set de objetos de tipo Repositorio
	 *            pasados por parametro.
	 * 
	 */

	public Repositorios(Set<Repositorio> repositorios) {
		super();
		this.repositorios = new HashSet<Repositorio>(repositorios);
	}

	/**
	 * @param Coleccion stream de tipo Repositorio
	 * 
	 *                  Contructo que inicializa un Set de objetor de tipo
	 *                  Repositorio haciendo uso de funciones de colecciones.
	 * 
	 */

	public Repositorios(Stream<Repositorio> repo) {
		this.repositorios = repo.collect(Collectors.toSet());
	}

	/**
	 * @param Objeto de tipo Repositorio
	 * 
	 *               Metodo de objeto que añade un elemento de tipo Repositorio al
	 *               set.
	 * 
	 */

	public void addRepo(Repositorio repo) {
		this.repositorios.add(repo);
	}

	/**
	 * @param Tipo enumerado; Lenguaje.
	 * 
	 *             Metodo de prueba contador
	 * 
	 */

	public Integer contadorLenguajes(Language lenguaje) {
		Integer cont = 0;

		for (Repositorio repositorio : repositorios) {
			if (lenguaje.equals(repositorio.getLanguage())) {
				cont++;
			}
		}
		return cont;

	}

	public Map<Language, Integer> getRepositorysbyLanguage() {
		Map<Language, Integer> res = new HashMap<>();
		for (Repositorio repositorio : repositorios) {
			if (res.containsKey(repositorio.getLanguage())) {
				res.put(repositorio.getLanguage(), res.get(repositorio.getLanguage()) + 1);
			} else {
				res.put(repositorio.getLanguage(), 1);
			}

		}
		return res;

	}

	public Map<Language, Double> getAverageStarsbyLanguage() {
		Map<Language, Double> res = new HashMap<>();
		for (Repositorio repositorio : repositorios) {

			if (!res.containsKey(repositorio.getLanguage())) {
				Double stars = 0.;
				Integer cont = 0;
				for (Repositorio repo : repositorios) {
					if (repo.getLanguage().equals(repositorio.getLanguage())) {
						stars += repo.getStarsNumber();
						cont++;
					}
				}
				res.put(repositorio.getLanguage(), (stars / cont));
			}
		}

		return res;
	}

	

	public Boolean haveStars(Integer minValue) {
		return repositorios.stream()
				.allMatch(x -> x.getStarsNumber() > minValue);
	}
	
	public Set<String> getAllTags(){
		return repositorios.stream()
				.flatMap(list -> list.getTags().stream())
				.collect(Collectors.toSet());
	}
	
//	Funcion que deternina si existen repositorios con una deterniada tag con un unbral de strellas
	public Boolean existRepoTagQuantityStars(String tag,Integer quantity) {
		return repositorios.stream()
				.anyMatch(x -> x.getTags().contains(tag) && x.getStarsNumber() > quantity);
	}
	
//	Funcion que comprueba si todos los repositorios que contiene una deternminada tag estangrados con un lenguage especifico
	public Boolean existRepoTagLanguage(String tag,Language language) {
		return repositorios.stream()
				.filter(x -> x.getTags().contains(tag))
				.allMatch(x -> x.getLanguage().equals(language));
	}
	
//	Funcion que muestran los distintos lenguajes que se usasn para una deterninada tag.
	public List<Language> getLanguageDistintOfTag(String tag){
		return repositorios.stream()
				.filter(x -> x.getTags().contains(tag))
				.map(x -> x.getLanguage())
				.distinct()
				.collect(Collectors.toList());
	}


	
//	Funcion que saca los nombres de los repositorios que contienen una etiqueta y un determinado lenguaje
	public Set<String> getfechasPrueba(String tag, Language language, Integer limit) {
		return repositorios.stream()
				.filter(x -> x.getTags().contains(tag) && x.getLanguage().equals(language))
				.sorted(Comparator.comparing(Repositorio::getStarsNumber).reversed())
				.map(x -> x.getRepoName())
				.limit(limit)
				.collect(Collectors.toSet());
	}
	
//	Funcion que obtiene listas de repositorios agrupado por el núnmero de strellas y discriminando por el lenguaje.
	public Map<Integer, List<Repositorio>> getRepositoryLanguageByStars(Language language) {
		return repositorios.stream()
				.filter(x -> x.getLanguage().equals(language))
				.collect(Collectors.groupingBy(Repositorio::getStarsNumber));
	}
//	Funcion que debuelbe la mediea aritmetica del numero de strellas del repositorio agrupado por el lenguaje
	public Map<Language,Double> getAverageStarsbyLanguageStream(){
		return repositorios.stream()
				.collect(Collectors.groupingBy(Repositorio::getLanguage,Collectors.averagingDouble(Repositorio::getStarsNumber)));
	}
	
//	Funcion que debuelbe el numero de repositorios agrupados por tag y
	
//	public Map<String,Long> getTagCount(){
//		return repositorios.stream()
//				.flatMap(x -> x.getTags().stream()).collect(Collectors.counting(Repositorio::getTags));
//	}
	


}

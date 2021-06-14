package fp.repositorio;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repositorios {

	private Set<Repositorio> repositorios = null;

	/**
	 * Constructor que inicializa un Set de objetos unicos vacio.
	 * 
	 */

	public Repositorios() {
		this.repositorios = new HashSet<Repositorio>();
	}

	/**
	 * @param Set de tipo Repositorio.
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
	 * @param Coleccion stream de tipo Repositorio.
	 * 
	 *                  Contructo que inicializa un Set de objetor de tipo
	 *                  Repositorio haciendo uso de funciones de colecciones.
	 * 
	 */

	public Repositorios(Stream<Repositorio> repo) {
		this.repositorios = repo.collect(Collectors.toSet());
	}

	/**
	 * @param Objeto de tipo Repositorio.
	 * 
	 *               Metodo de objeto que añade un elemento de tipo Repositorio al
	 *               set.
	 * 
	 */

	public void addRepo(Repositorio repo) {
		this.repositorios.add(repo);
	}

	/**
	 *
	 * Metodo que crea un diccionario con los lenguajes por clave y el conteo de la
	 * aparicion de los mismos, realizado como un metodo tradicional.
	 * 
	 * @return Diccionario de tipo clave lenguaje y valor entero.
	 * 
	 */

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

	/**
	 *
	 * Metodo que crea un diccionario con los lenguajes por clave y la media
	 * aritmetica de los mismos.
	 * 
	 * @return Diccionario de tipo clave lenguaje y valor numericon con decimales.
	 * 
	 */

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

	/**
	 *
	 * Metodo que devuelve un lista de cadenas que son todas las tags que contiene
	 * el fichero csv.
	 * 
	 * @return Lista de cadenas.
	 * 
	 */

	public List<String> getAllTags() {
		return repositorios.stream().flatMap(x -> x.getTags().stream()).distinct().collect(Collectors.toList());
	}

	/**
	 * @param Objeto tipo cadena que hace referencia a una etiqueta.
	 *
	 *               Metodo que devuelve una variable de timpo entero largo haciendo
	 *               referencia al conteo de lenguajes que contiene una tag
	 *               determinada.
	 * 
	 * @return Numero entero largo.
	 * 
	 */

	public Long counterLanguages(String tag) {
		return repositorios.stream().filter(x -> x.getTags().contains(tag)).count();
	}

	/**
	 * @param Entero    como valor minimo.
	 * @param Enumerado de tipo Language.
	 *
	 *                  Funcion que comprueba aquellos repositorios desarrollados en
	 *                  un lenguaje cumpliendo todos un valor minimo de estrellas.
	 * 
	 * @return Variable booleana.
	 * 
	 */

	public Boolean haveStars(Integer minValue, Language lan) {
		return repositorios.stream().filter(x -> x.getLanguage().equals(lan))
				.allMatch(x -> x.getStarsNumber() > minValue);
	}

	/**
	 * @param Cadena que hace referencia a una etiqueta.
	 * @param Entero que es el valor maximo.
	 * @param Entero con el valor de un año yyyy.
	 * 
	 *               Funcion que deternina si existen algunos repositorios con una
	 *               deterniada tag con un unbral de strellas en un year
	 *               determinado.
	 * 
	 * @return Variable booleana.
	 * 
	 */

	public Boolean existRepoTagQuantityStars(String tag, Integer quantity, Integer year) {
		return repositorios.stream().filter(x -> x.getLastUpdate().getYear() == year)
				.anyMatch(x -> x.getTags().contains(tag) && x.getStarsNumber() > quantity);
	}

	/**
	 * 
	 * @param Cadena    que hace referencia a una etiqueta.
	 * @param Enumerado de tipo Language.
	 *
	 *                  Funcion que comprueba si todos los repositorios que contiene
	 *                  una deternminada tag estan desarrollados con un lenguage
	 *                  especifico.
	 * 
	 * @return Variable booleana.
	 * 
	 */

	public Boolean existRepoTagLanguage(String tag, Language language) {
		return repositorios.stream().filter(x -> x.getTags().contains(tag))
				.allMatch(x -> x.getLanguage().equals(language));
	}

	/**
	 * @param Cadena que hace referencia a una etiqueta.
	 *
	 *               Funcion que muestran los distintos lenguajes que se usan para
	 *               una deterninada tag por ordena natural.
	 * 
	 * @return Lista de lenguajes.
	 * 
	 */

	public List<Language> getLanguageDistintOfTag(String tag) {
		return repositorios.stream().filter(x -> x.getTags().contains(tag)).map(x -> x.getLanguage()).distinct()
				.sorted().collect(Collectors.toList());
	}

	/**
	 * @param Cadena    que hace referencia a una etiqueta.
	 * @param Enumerado de tipo Language.
	 * @param Entero    que hace referencia a un limite.
	 *
	 *                  Funcion que saca los nombres de los repositorios que
	 *                  contienen una etiqueta y un determinado lenguaje, haciendo
	 *                  una ordenacion por numero de strellas.
	 * 
	 * 
	 * @return Conjunto de cadenas con los nombres del repositorio.
	 * 
	 */

	public Set<String> getNamesByTagLanguage(String tag, Language language, Integer limit) {
		return repositorios.stream().filter(x -> x.getTags().contains(tag) && x.getLanguage().equals(language))
				.sorted(Comparator.comparing(Repositorio::getStarsNumber).reversed()).map(x -> x.getRepoName())
				.limit(limit).collect(Collectors.toSet());
	}

	/**
	 * 
	 * @param Enumerado de tipo Language.
	 *
	 *                  Funcion que obtiene listas de repositorios agrupado por el
	 *                  núnmero de strellas y discriminando por el lenguaje.
	 * 
	 * 
	 * @return Diccionario con clave de enteros que hacen referencia al numero de
	 *         estrellas y valor listas de repositorios.
	 * 
	 */

	public Map<Integer, List<Repositorio>> getRepositoryLanguageByStars(Language language) {
		return repositorios.stream().filter(x -> x.getLanguage().equals(language))
				.collect(Collectors.groupingBy(Repositorio::getStarsNumber));
	}

	/**
	 *
	 * Funcion que debuelbe la mediea aritmetica del numero de strellas del
	 * repositorio agrupado por el lenguaje.
	 * 
	 * 
	 * @return Diccionario con clave de tipo Language y valor numerico con decimales
	 *         de la media de strellas.
	 * 
	 */

	public Map<Language, Double> getAverageStarsbyLanguageStream() {
		return repositorios.stream().collect(Collectors.groupingBy(Repositorio::getLanguage,
				Collectors.averagingDouble(Repositorio::getStarsNumber)));
	}

	/**
	 * @param Cadena que hace referencia a una etiqueta.
	 * 
	 *
	 *               Funcion que agrupa los lenguajes y cuenta el número de veces
	 *               que apareve con una etiqueta especifica.
	 * 
	 * 
	 * @return Diccionario con clave de tipo Language y valor numerico entero largo.
	 * 
	 */

	public Map<Language, Long> getNumberLanguagesbyTag(String tag) {

		return repositorios.stream().filter(x -> x.getTags().contains(tag))
				.collect(Collectors.groupingBy(Repositorio::getLanguage, Collectors.counting()));
	}

	/**
	 * 
	 * @param Cadena que hace referencia a una etiqueta.
	 *
	 *               Funcion que debuelve la clave de un diccionario correspondiendo
	 *               con el lenguage más usado para una determinada tag.
	 * 
	 * 
	 * @return Language
	 * 
	 */

	public Language getMostUsedLanguageByTag(String tag) {

		Map<Language, Long> contLang = getNumberLanguagesbyTag(tag);

		return contLang.entrySet().stream().max(Comparator.comparing(x -> x.getValue())).get().getKey();
	}

	/**
	 * 
	 * 
	 *
	 * Funcion que devuelve un lenguage haciendo referencia a que tiene menor media
	 * de estrellas dadas por la comunidad.
	 * 
	 * 
	 * @return Language
	 * 
	 */

	public Language getMinOfStars() {

		Map<Language, Double> averLang = getAverageStarsbyLanguage();

		return averLang.entrySet().stream().min(Comparator.comparing(x -> x.getValue())).get().getKey();
	}

	@Override
	public String toString() {
		return "Repositorios [repositorios=" + repositorios + "]";
	}

}

package fp.repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.format.DateTimeFormatter;
import fp.utils.Checkers;

public class Repositorio implements Comparable<Repositorio> {

	private String username;
	private String repoName;
	private String description;
	private LocalDateTime lastUpdate;
	private Language language;
	private Integer starsNumber;
	private ArrayList<String> tags;

	/**
	 * @param userName    Cadena con el nombre de usuario del repositorio remoto.
	 * @param repoName    Cadena con el nombre del repositorio.
	 * @param description Descripcion del proyecto almacenado en el repositorio.
	 * @param lastUpdate  Fecha de la ultima actualizacion del repositorio.
	 * @param language    Tipo enumerado que representa el lenguaje de programacion
	 * @param startNumber Numero de estrellas
	 * @param tags        Etiquetas asociadas a rasgos caracteristicos del
	 *                    repositorio que lo identifican.
	 * 
	 *                    Constructor que inicializa un objeto de tipo Repositorio,
	 *                    con todos los valores de entrada.
	 */

	public Repositorio(String username, String repoName, String description, LocalDateTime lastUpdate,
			Language language, Integer starsNumber, String[] tags) {

		super();
		Checkers.check("The number of stars cannot be negative.", starsNumber > 0);
		this.username = username;
		this.repoName = repoName;
		this.description = description;
		this.lastUpdate = lastUpdate;
		this.language = language;
		this.starsNumber = starsNumber;
		this.tags = new ArrayList<String>(Arrays.asList(tags));

	}

	/**
	 * @param str Cadena de texto que contiene la informacion de un objeto separadas
	 *            entre comas.
	 * 
	 *            Constructor que inicializa un objeto de tipo Repositorio,
	 *            insertando solamente una cadena de texto.
	 * 
	 */

	public Repositorio(String str) {

		super();

		String[] splitCadena = str.split(",");

		this.username = splitCadena[0];
		this.repoName = splitCadena[1];
		this.description = splitCadena[2];
		this.lastUpdate = LocalDateTime.parse(splitCadena[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String aux = "";

		if (splitCadena[4].contains("+")) {

			aux = splitCadena[4].substring(0, 1) + "PLUSPLUS";

		} else {

			if (splitCadena[4].contains("-")) {

				aux = splitCadena[4].replaceAll("-", "");

			} else {

				if (splitCadena[4].contains(" ")) {

					aux = splitCadena[4].replaceAll(" ", "");

				} else {

					aux = splitCadena[4];

				}

			}
		}
		if (!splitCadena[4].equals("")) {

			this.language = Language.valueOf(aux.trim().toUpperCase());

		} else {

			this.language = Language.NOPROLAN;

		}

		if (splitCadena[5].contains(".")) {

			aux = splitCadena[5].replaceAll("k", "00");

		} else {

			aux = splitCadena[5].replaceAll("k", "000");

		}

		Checkers.check("The number of stars cannot be negative.", Integer.parseInt(aux.replace(".", "")) > 0);
		this.starsNumber = Integer.parseInt(aux.replace(".", ""));

		this.tags = new ArrayList<String>(Arrays.asList(splitCadena[6].split("/")));

	}

	/*
	 * Conjunto de getters y setters generados automaticamente por el IDE
	 */

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getRepoName() {

		return repoName;

	}

	public void setRepoName(String repoName) {

		this.repoName = repoName;

	}

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	public LocalDateTime getLastUpdate() {

		return lastUpdate;

	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		Checkers.check("The number of stars cannot be negative.", starsNumber > 0);
		this.lastUpdate = lastUpdate;

	}

	public Language getLanguage() {

		return language;

	}

	public void setLanguage(Language language) {

		this.language = language;

	}

	public Integer getStarsNumber() {

		return starsNumber;

	}

	public void setStarsNumber(Integer starsNumber) {

		this.starsNumber = starsNumber;

	}

	public ArrayList<String> getTags() {

		return tags;

	}

	public void setTags(ArrayList<String> tags) {

		this.tags = tags;

	}

	/*
	 * Propiedad derivada que devuelve una variable booleana dando informacion del
	 * si el repositorio alberga codigo o si es de otro tipo.
	 * 
	 * @return res Valor booleano True: Contiene codigo; False: Otro.
	 */

	public Boolean getIsCode() {

		boolean res = true;

		if (this.language == Language.NOPROLAN) {

			res = false;

		}

		return res;

	}

	/*
	 * Propiedad derivada que genera al URL del repositorio de github.
	 * 
	 * @return URL del repositorio remoto.
	 */

	public String getUrl() {

		return "https://github.com/" + this.getUsername() + "/" + this.getRepoName();

	}

	/*
	 * Aqui se describe la forma en la que se mostrara el metodo toString de cada
	 * uno de los objetos que se instancie.
	 */

	@Override
	public String toString() {

		return "OBJETO REPOSITORIO\n User Name= " + username + ",\n Repository Name= " + repoName + ",\n description= "
				+ description + ",\n lastUpdate= " + lastUpdate + ",\n language= " + language + ",\n starsNumber= "
				+ starsNumber + ",\n tags= " + tags;

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;

		result = prime * result + ((repoName == null) ? 0 : repoName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());

		return result;

	}

	/*
	 * Para que un repositorio se considere igual que otro deben tener el mismo
	 * nombre de usuairo y el nombre del repositorio.
	 */

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repositorio other = (Repositorio) obj;
		if (repoName == null) {

			if (other.repoName != null)
				return false;

		} else if (!repoName.equals(other.repoName))
			return false;
		if (username == null) {

			if (other.username != null)
				return false;

		} else if (!username.equals(other.username))

			return false;

		return true;

	}

	/*
	 * En caso de conflicto en la ordenacion tomara como primera el nombre del
	 * usaurio del repositoro y com osegunda opcion el nombre del repositorio.
	 */

	@Override
	public int compareTo(Repositorio repo) {
		int res = this.getUsername().compareTo(repo.getUsername());
		if (res == 0) {
			res = this.getRepoName().compareTo(repo.getRepoName());
		}
		return res;
	}

}

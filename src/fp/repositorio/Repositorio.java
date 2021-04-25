package fp.repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.format.DateTimeFormatter;

public class Repositorio {

	private String username;
	private String repoName;
	private String description;
	private LocalDateTime lastUpdate;
	private Language language;
	private Integer starsNumber;
	private ArrayList<String> tags;

	public Repositorio(String username, String repoName, String description, LocalDateTime lastUpdate,
			Language language, Integer starsNumber, ArrayList<String> tags) {
		super();
		this.username = username;
		this.repoName = repoName;
		this.description = description;
		this.lastUpdate = lastUpdate;
		this.language = language;
		this.starsNumber = starsNumber;
		this.tags = tags;
	}

	public Repositorio(String cadena) {
		super();
		String[] splitCadena = cadena.split(",");
		this.username = splitCadena[0];
		this.repoName = splitCadena[1];
		this.description = splitCadena[2];
		this.lastUpdate = LocalDateTime.parse(splitCadena[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String aux = "";
		
		if (splitCadena[4].contains("+")) {
			aux = splitCadena[4].substring(0, 1) + "PLUSPLUS";
			System.out.println(aux);
		} else {
			if (splitCadena[4].contains("-")) {
				aux = splitCadena[4].replaceAll("-", "");
			} else {
				aux = splitCadena[4];
			}
		}
		if(!splitCadena[4].equals("")) {
			this.language = Language.valueOf(aux.trim().toUpperCase());
		}else {
			this.language = Language.NOPROLAN;
		}
		
		if (splitCadena[5].contains(".")) {
			aux = splitCadena[5].replaceAll("k", "00");
		} else {
			aux = splitCadena[5].replaceAll("k", "000");
		}
		this.starsNumber = Integer.parseInt(aux);
		this.tags = new ArrayList<String>(Arrays.asList(splitCadena[6].split(",")));
	}

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

	@Override
	public String toString() {
		return "Repositorio [username=" + username + ", repoName=" + repoName + ", description=" + description
				+ ", lastUpdate=" + lastUpdate + ", language=" + language + ", starsNumber=" + starsNumber + ", tags="
				+ tags + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((repoName == null) ? 0 : repoName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

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

}

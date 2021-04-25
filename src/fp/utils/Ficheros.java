package fp.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ficheros {

	public List<String> leerFicheros(String path) {
		List<String> res = null;
		try {
			res = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		res.remove(0);
		return res;
	}

}

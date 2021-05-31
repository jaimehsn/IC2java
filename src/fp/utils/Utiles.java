package fp.utils;

import java.util.Map;

public class Utiles {

	public static <K, V> void show(Map<? extends K, ? extends V> m) {

		for (K e : m.keySet()) {

			System.out.println(e + " --> " + m.get(e));

		}

	}

}

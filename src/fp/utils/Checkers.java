package fp.utils;

public class Checkers {
	public static void check(String alert, Boolean condition) {
		if (!condition) {
			throw new IllegalArgumentException(alert);
		}
	}
}

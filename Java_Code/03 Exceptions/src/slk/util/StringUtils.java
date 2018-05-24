package slk.util;

public class StringUtils {

	public static boolean containsDigit(String text) {
		for (int i = 0, j = text.length(); i < j; i++) {
			char ch = text.charAt(i);
			if (Character.isDigit(ch)) {
				return true;
			}
		}
		return false;
	}

}

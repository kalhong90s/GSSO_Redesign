package ais.dpms.gsso.utils;

public class Validator {
	public static boolean validateString(String... values) {
        for (String val : values) {
            if (val == null || "".equals(val) || val.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

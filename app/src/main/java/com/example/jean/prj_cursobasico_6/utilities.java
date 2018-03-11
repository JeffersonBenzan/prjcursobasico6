package com.example.jean.prj_cursobasico_6;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class utilities {

    public static boolean isNullOrWhitespace(String s) {
        return s == null || isWhitespace(s);

    }
    private static boolean isWhitespace(String s) {
        int length = s.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
    }
}

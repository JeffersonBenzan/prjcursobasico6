package com.example.jean.prj_cursobasico_6;


import java.math.BigDecimal;
import java.math.RoundingMode;

class utilities {

    static double redondear(double value) {

        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();

    }
}

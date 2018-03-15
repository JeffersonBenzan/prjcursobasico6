package com.example.jean.prj_cursobasico_6;


import java.math.BigDecimal;
import java.math.RoundingMode;

class utilities {

    static double redondear(double value) {

        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();

    }

    static double PiesYPulgadasAMetros(String estatura){
        String[] altura = estatura.split("\\.");
        double pies = Double.parseDouble(altura[0]);
        double pulgadas = Double.parseDouble(altura[1])/12;

        return (pies * 0.3048) + (pulgadas * 0.3048);
    }

    static double LibraAKilogramo(Double masa){

        return masa * 0.453592;
    }
}

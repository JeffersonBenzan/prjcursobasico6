package Utilities;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilities {

    public static double Redondear(double Value) {

        return new BigDecimal(Value).setScale(2, RoundingMode.HALF_UP).doubleValue();

    }

    public static double PiesYPulgadasAMetros(String Estatura){
        String[] Altura = Estatura.split("\\.");
        double Pies = Double.parseDouble(Altura[0]);
        double Pulgadas = Double.parseDouble(Altura[1])/12;

        return (Pies * 0.3048) + (Pulgadas * 0.3048);
    }

    public static double LibraAKilogramo(Double Masa){

        return Masa * 0.453592;
    }

    public static double KilogramoALibra(Double Masa){

        return Masa / 0.453592;
    }
}

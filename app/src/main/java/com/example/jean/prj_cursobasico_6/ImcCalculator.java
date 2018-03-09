package com.example.jean.prj_cursobasico_6;

/**
 * Created by Jean on 09-Mar-18.
 */

public class ImcCalculator {

    public static void main (String [] args){

        //Masa en libras y estatura en pies
        double masa = 160;
        double estatura = 5.7;

        //Hacemos conversion necesaria a masa en kilogramos y estatura en metros
        masa = masa * 0.453592;
        estatura = estatura * 0.3048;

        //Calculamos el IMC
        double imcCalc = masa / (estatura*estatura);
        System.out.println("Tu IMC es: "+imcCalc);

        //Indicamos en que rango de peso estas segun tu IMC calculado
        String imcFinal = null;
        if (imcCalc < 18.50)
        {
            imcFinal = "peso Bajo";
        } else if (18.50 <= imcCalc && imcCalc <= 25)
        {
            imcFinal = "peso Normal";
        } else if (25 < imcCalc)
        {
            imcFinal = "Sobrepeso";
        }
        System.out.println("Tienes "+imcFinal);
    }

}

package com.example.jean.prj_cursobasico_6;

public class ImcCalculator {

    //Enumeracion que indica el estado de una persona segun su IMC
    public enum IndiceMasaCorporal {
        PesoInsuficiente,
        PesoNormal,
        Sobrepeso,
        Preobecidad,
        ObecidadLeve,
        ObecidadModerada,
        ObecidadMorbida,
        ObecidadExtrema;

        String getName(){

            String name = "";

            switch (this){
                case PesoInsuficiente:
                    name = "PESO INSUFICIENTE";
                    break;
                case PesoNormal:
                    name = "PESO NORMAL";
                    break;
                case Sobrepeso:
                    name = "SOBREPESO";
                    break;
                case Preobecidad:
                    name = "PREOBECIDAD";
                    break;
                case ObecidadLeve:
                    name = "OBECIDAD LEVE";
                    break;
                case ObecidadModerada:
                    name = "OBECIDAD MODERADA";
                    break;
                case ObecidadMorbida:
                    name = "OBECIDAD MORBIDA";
                    break;
                case ObecidadExtrema:
                    name = "OBECIDAD EXTREMA";
                    break;
            }

            return name;
        }
    }

    //Segun la estatura y masa, calcular el IMC.
    //El parametro conversion sirve para convertir la masa y el peso en kilogramos
    // y en metros respectivamente si estos se pasaron en libras y pies.
    public static double calcularImc(double masa, double estatura, boolean conversion){

        //Hacemos conversion si es necesaria de libra en kilogramos y de pies a metros
        if (conversion) {
            masa = masa * 0.453592;
            estatura = estatura * 0.3048;
        }


        return masa / Math.pow(estatura, 2);
    }


    //Segun el Indice de masa corporal suministrado, decir en que rango se encuentra la persona.
    public static String indicarImc(double Imc){
        if (Imc < 18.5){
            return IndiceMasaCorporal.PesoInsuficiente.getName();
        }
        else if (Imc >= 18.5 && Imc < 24.9){
            return IndiceMasaCorporal.PesoNormal.getName();
        }
        else if (Imc >= 25 && Imc < 26.9){
            return IndiceMasaCorporal.Sobrepeso.getName();
        }
        else if (Imc >= 27 && Imc < 29.9){
            return IndiceMasaCorporal.Preobecidad.getName();
        }
        else if (Imc >= 30 && Imc < 34.9){
            return IndiceMasaCorporal.ObecidadLeve.getName();
        }
        else if (Imc >= 35 && Imc < 39.9){
            return IndiceMasaCorporal.ObecidadModerada.getName();
        }
        else if (Imc >= 25 && Imc < 26.9){
            return IndiceMasaCorporal.ObecidadMorbida.getName();
        }
        else {
            return IndiceMasaCorporal.ObecidadExtrema.getName();
        }
    }

    /*public static void main (String [] args){

        //Masa en libras y estatura en pies
        double masa = 160;
        double estatura = 5.7;

        double imcCalc = calcularImc(masa, estatura, true);
        System.out.println("Tu IMC es: "+imcCalc);

        //Indicamos en que rango de peso estas segun tu IMC calculado
        String imcFinal = indicarImc(imcCalc);

        System.out.println("Tienes "+imcFinal.toLowerCase());
    }*/

}

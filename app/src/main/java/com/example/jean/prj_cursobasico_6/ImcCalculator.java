package com.example.jean.prj_cursobasico_6;

class ImcCalculator {

    public enum PesoUnit{
        Libras,
        Kilogramos
    }

    public enum EstaturaUnit{
        Metros,
        Pies
    }

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
    static double calcularImc(double masa, double estatura, EstaturaUnit estaturaUnit, PesoUnit pesoUnit){

        if (pesoUnit == PesoUnit.Libras){
            masa = masa * 0.453592;
        }
        if (estaturaUnit == EstaturaUnit.Pies){
            estatura = estatura * 0.3048;
        }

        return masa / Math.pow(estatura, 2);
    }


    //Segun el Indice de masa corporal suministrado, decir en que rango se encuentra la persona.
    static String indicarImc(double Imc){
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

}

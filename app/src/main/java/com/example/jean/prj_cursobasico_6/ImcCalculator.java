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
        ObecidadExtrema,
        FueraDeRango;

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
                case FueraDeRango:
                    name = "Fuera De Rango";
                    break;
            }

            return name;
        }
    }

    //Segun la estatura y masa, calcular el IMC.
    static double calcularImc(double masa, String estatura, EstaturaUnit estaturaUnit, PesoUnit pesoUnit){

        Double estaturaDouble = Double.parseDouble(estatura);

        if (pesoUnit == PesoUnit.Libras){

            masa = utilities.LibraAKilogramo(masa);
        }
        if (estaturaUnit == EstaturaUnit.Pies){

            estaturaDouble = utilities.PiesYPulgadasAMetros(estatura);
        }

        return masa / Math.pow(estaturaDouble, 2);
    }


    //Segun el Indice de masa corporal suministrado, decir en que rango se encuentra la persona.
    static String indicarImc(double Imc){
        if (Imc < 18.5){
            return IndiceMasaCorporal.PesoInsuficiente.getName();
        }
        else if (Imc >= 18.5 && Imc < 25){
            return IndiceMasaCorporal.PesoNormal.getName();
        }
        else if (Imc >= 25 && Imc < 27){
            return IndiceMasaCorporal.Sobrepeso.getName();
        }
        else if (Imc >= 27 && Imc < 30){
            return IndiceMasaCorporal.Preobecidad.getName();
        }
        else if (Imc >= 30 && Imc < 35){
            return IndiceMasaCorporal.ObecidadLeve.getName();
        }
        else if (Imc >= 35 && Imc < 40){
            return IndiceMasaCorporal.ObecidadModerada.getName();
        }
        else if (Imc >= 40 && Imc < 50){
            return IndiceMasaCorporal.ObecidadMorbida.getName();
        }
        else if (Imc > 50){
            return IndiceMasaCorporal.ObecidadExtrema.getName();
        }  else {
            return IndiceMasaCorporal.FueraDeRango.getName();
        }

    }

    //Recomendacion para estar en peso normal
    static String calcularRecomendacion(double masa, String estatura, EstaturaUnit estaturaUnit, PesoUnit pesoUnit){

        Double estaturaDouble = Double.parseDouble(estatura);

        if (pesoUnit == PesoUnit.Libras){

            masa = utilities.LibraAKilogramo(masa);
        }
        if (estaturaUnit == EstaturaUnit.Pies){

            estaturaDouble = utilities.PiesYPulgadasAMetros(estatura);
        }

        double imc = masa / Math.pow(estaturaDouble, 2);
        double masaRecomendada;

        if (imc >= 25)
        {
            masaRecomendada = Math.abs((24.9 * Math.pow(estaturaDouble, 2)) - masa);
            masaRecomendada = utilities.redondear(masaRecomendada);
            if (pesoUnit == PesoUnit.Libras)
            {
                masaRecomendada = utilities.KilogramoALibra(masaRecomendada);
                masaRecomendada = utilities.redondear(masaRecomendada);
            }
            return "¡DEJE LOS CHIMIS Y LA MALA VIDA!, baje " + masaRecomendada + " "+pesoUnit+" para ponerse fit";
        } else if (imc < 18.5)
        {
            masaRecomendada = Math.abs(masa - (18.5 * Math.pow(estaturaDouble, 2)));
            masaRecomendada = utilities.redondear(masaRecomendada);
            if (pesoUnit == PesoUnit.Libras)
            {
                masaRecomendada = utilities.KilogramoALibra(masaRecomendada);
                masaRecomendada = utilities.redondear(masaRecomendada);
            }
            return "¡PROGRAME MENOS Y COMA MAS!, suba " + masaRecomendada + " "+pesoUnit+" para ponerse fit";
        }else
        {
            return "Sigue asi campeon!";
        }

    }
}

package ImcCalculator;

import Utilities.Utilities;

public class ImcCalculator {

    public enum PesoUnit{
        Libras,
        Kilogramos
    }

    public enum EstaturaUnit{
        Pies,
        Metros

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

        String GetName(){

            String Name = "";

            switch (this){
                case PesoInsuficiente:
                    Name = "PESO INSUFICIENTE";
                    break;
                case PesoNormal:
                    Name = "PESO NORMAL";
                    break;
                case Sobrepeso:
                    Name = "SOBREPESO";
                    break;
                case Preobecidad:
                    Name = "PREOBECIDAD";
                    break;
                case ObecidadLeve:
                    Name = "OBECIDAD LEVE";
                    break;
                case ObecidadModerada:
                    Name = "OBECIDAD MODERADA";
                    break;
                case ObecidadMorbida:
                    Name = "OBECIDAD MORBIDA";
                    break;
                case ObecidadExtrema:
                    Name = "OBECIDAD EXTREMA";
                    break;
                case FueraDeRango:
                    Name = "Fuera De Rango";
                    break;
            }

            return Name;
        }
    }

    //Segun la Estatura y Masa, calcular el IMC.
    public static double CalcularImc(double Masa, String Estatura, EstaturaUnit EstaturaUnit, PesoUnit PesoUnit){

        Double EstaturaDouble = Double.parseDouble(Estatura);

        if (PesoUnit == ImcCalculator.PesoUnit.Libras){

            Masa = Utilities.LibraAKilogramo(Masa);
        }
        if (EstaturaUnit == ImcCalculator.EstaturaUnit.Pies){

            EstaturaDouble = Utilities.PiesYPulgadasAMetros(Estatura);
        }

        return Masa / Math.pow(EstaturaDouble, 2);
    }


    //Segun el Indice de masa corporal suministrado, decir en que rango se encuentra la persona.
    public static String IndicarImc(double Imc){
        if (Imc < 18.5){
            return IndiceMasaCorporal.PesoInsuficiente.GetName();
        }
        else if (Imc >= 18.5 && Imc < 25){
            return IndiceMasaCorporal.PesoNormal.GetName();
        }
        else if (Imc >= 25 && Imc < 27){
            return IndiceMasaCorporal.Sobrepeso.GetName();
        }
        else if (Imc >= 27 && Imc < 30){
            return IndiceMasaCorporal.Preobecidad.GetName();
        }
        else if (Imc >= 30 && Imc < 35){
            return IndiceMasaCorporal.ObecidadLeve.GetName();
        }
        else if (Imc >= 35 && Imc < 40){
            return IndiceMasaCorporal.ObecidadModerada.GetName();
        }
        else if (Imc >= 40 && Imc < 50){
            return IndiceMasaCorporal.ObecidadMorbida.GetName();
        }
        else if (Imc > 50){
            return IndiceMasaCorporal.ObecidadExtrema.GetName();
        }  else {
            return IndiceMasaCorporal.FueraDeRango.GetName();
        }

    }

    //Recomendacion para estar en peso normal
    public static String CalcularRecomendacion(double Masa, String Estatura, EstaturaUnit EstaturaUnit, PesoUnit PesoUnit){

        Double EstaturaDouble = Double.parseDouble(Estatura);

        if (PesoUnit == ImcCalculator.PesoUnit.Libras){

            Masa = Utilities.LibraAKilogramo(Masa);
        }
        if (EstaturaUnit == ImcCalculator.EstaturaUnit.Pies){

            EstaturaDouble = Utilities.PiesYPulgadasAMetros(Estatura);
        }

        double Imc = Masa / Math.pow(EstaturaDouble, 2);
        double MasaRecomendada;

        if (Imc >= 25)
        {
            MasaRecomendada = Math.abs((24.9 * Math.pow(EstaturaDouble, 2)) - Masa);
            MasaRecomendada = Utilities.Redondear(MasaRecomendada);
            if (PesoUnit == ImcCalculator.PesoUnit.Libras)
            {
                MasaRecomendada = Utilities.KilogramoALibra(MasaRecomendada);
                MasaRecomendada = Utilities.Redondear(MasaRecomendada);
            }
            return "¡DEJE LOS CHIMIS Y LA MALA VIDA!, baje " + MasaRecomendada + " "+PesoUnit+" para ponerse fit";
        } else if (Imc < 18.5)
        {
            MasaRecomendada = Math.abs(Masa - (18.5 * Math.pow(EstaturaDouble, 2)));
            MasaRecomendada = Utilities.Redondear(MasaRecomendada);
            if (PesoUnit == ImcCalculator.PesoUnit.Libras)
            {
                MasaRecomendada = Utilities.KilogramoALibra(MasaRecomendada);
                MasaRecomendada = Utilities.Redondear(MasaRecomendada);
            }
            return "¡PROGRAME MENOS Y COMA MAS!, suba " + MasaRecomendada + " "+PesoUnit+" para ponerse fit";
        }else
        {
            return "Sigue asi campeon!";
        }

    }
}

package edu.jsu.mcis.cs408.tabcalculator_converter.Model;

import java.util.Locale;

public class DistanceModel {



    public DistanceModel(){

    }

    public String distanceConversion(String miles, String kilometers){
        float conversion;
        if(miles.isEmpty() && !kilometers.isEmpty()){
            conversion = kilometerToMiles(Float.parseFloat(kilometers));
        }
        else if (kilometers.isEmpty() && !miles.isEmpty()){
            conversion = milesToKilometers(Float.parseFloat(miles));
        }
        else  {
            conversion = milesToKilometers(Float.parseFloat(miles));
        }
        return String.format(Locale.ENGLISH, "%.2f", conversion);
    }

    private float milesToKilometers(float miles) {
        return (float) (miles * 1.609344);
    }
    private float kilometerToMiles(float kilometers){
        return (float) (kilometers * 0.62137119);
    }
}

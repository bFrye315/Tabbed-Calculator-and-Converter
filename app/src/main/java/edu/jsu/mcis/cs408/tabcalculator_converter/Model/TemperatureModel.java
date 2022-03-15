package edu.jsu.mcis.cs408.tabcalculator_converter.Model;

import java.util.Locale;

public class TemperatureModel {

    public TemperatureModel(){

    }

    public String tempConversion(String fahrenheit, String celsius){
        float conversion;
        if(fahrenheit.isEmpty() && !celsius.isEmpty()){
            conversion = celsiusToFahrenheit(Float.parseFloat(celsius));
        }
        else if (celsius.isEmpty() && !fahrenheit.isEmpty()){
            conversion = fahrenheitToCelsius(Float.parseFloat(fahrenheit));
        }
        else  {
            conversion = fahrenheitToCelsius(Float.parseFloat(fahrenheit));
        }
        return String.format(Locale.ENGLISH, "%.2f", conversion);
    }

    private float fahrenheitToCelsius(float fahrenheit){
        return (5 * (fahrenheit - 32) / 9);
    }

    private float celsiusToFahrenheit(float celsius){
        return (9 * (celsius) + (5 * 32)) / 5;
    }


}

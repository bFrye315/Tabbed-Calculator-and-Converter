package edu.jsu.mcis.cs408.tabcalculator_converter.Model;

import java.util.Locale;

public class TipModel {

    public TipModel(){

    }

    public String tipCalculate(String billTotal, String tipPercentage, String numOfPeople){

        float total = Float.parseFloat(billTotal);
        float percent = Float.parseFloat(tipPercentage);
        float people = Float.parseFloat(numOfPeople);

        float totalCal = (((percent / 100) + 1) * total) / people;

        return String.format(Locale.ENGLISH,"%.2f", totalCal);
    }
}

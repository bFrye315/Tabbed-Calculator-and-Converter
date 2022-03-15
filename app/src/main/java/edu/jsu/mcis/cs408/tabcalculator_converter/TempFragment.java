package edu.jsu.mcis.cs408.tabcalculator_converter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.tabcalculator_converter.Model.TemperatureModel;
import edu.jsu.mcis.cs408.tabcalculator_converter.databinding.TemperatureConverterFragmentBinding;


public class TempFragment extends Fragment {

    public static final String ARG_ID = "id";

    private TemperatureModel temperatureModel;
    private TemperatureConverterFragmentBinding temperatureBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        temperatureBinding = TemperatureConverterFragmentBinding.inflate(getLayoutInflater(), container, false);
        return temperatureBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        temperatureBinding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temperatureModel = new TemperatureModel();
                String fahrenheit = String.valueOf(temperatureBinding.Fahrenheit.getText());
                String celsius = String.valueOf(temperatureBinding.Celcius.getText());
                String conversion;

                if(fahrenheit.isEmpty() && celsius.isEmpty()){
                    Toast toast = Toast.makeText(temperatureBinding.getRoot().getContext(), getString(R.string.temp_empty), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(fahrenheit.isEmpty()){
                    conversion = temperatureModel.tempConversion(fahrenheit, celsius);
                    temperatureBinding.Fahrenheit.setText(conversion);
                }
                else if (celsius.isEmpty()){
                    conversion = temperatureModel.tempConversion(fahrenheit, celsius);
                    temperatureBinding.Celcius.setText(conversion);
                }
                else {
                    conversion = temperatureModel.tempConversion(fahrenheit, celsius);
                    temperatureBinding.Celcius.setText(conversion);
                }

            }
        });
    }
}



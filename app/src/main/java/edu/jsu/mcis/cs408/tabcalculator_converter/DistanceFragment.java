package edu.jsu.mcis.cs408.tabcalculator_converter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.tabcalculator_converter.Model.DistanceModel;
import edu.jsu.mcis.cs408.tabcalculator_converter.databinding.DistanceConverterFragmentBinding;

public class DistanceFragment extends Fragment {
    public static final String ARG_ID = "id";

    private DistanceModel distanceModel;
    private DistanceConverterFragmentBinding distanceBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        distanceBinding = DistanceConverterFragmentBinding.inflate(getLayoutInflater(), container, false);
        return distanceBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        distanceBinding.distanceConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distanceModel = new DistanceModel();

                String miles = String.valueOf(distanceBinding.mileAmount.getText());
                String kilometers = String.valueOf(distanceBinding.kilometerAmount.getText());
                String conversion;

                if(miles.isEmpty() && kilometers.isEmpty()){
                    Toast toast = Toast.makeText(distanceBinding.getRoot().getContext(), R.string.distance_empty, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(miles.isEmpty()){
                    conversion = distanceModel.distanceConversion(miles, kilometers);
                    distanceBinding.mileAmount.setText(conversion);
                }
                else if (kilometers.isEmpty()){
                    conversion = distanceModel.distanceConversion(miles, kilometers);
                    distanceBinding.kilometerAmount.setText(conversion);
                }
                else {
                    conversion = distanceModel.distanceConversion(miles, kilometers);
                    distanceBinding.kilometerAmount.setText(conversion);
                }
            }
        });
    }
}


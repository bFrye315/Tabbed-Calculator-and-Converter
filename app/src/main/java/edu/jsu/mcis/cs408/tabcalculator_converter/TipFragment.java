package edu.jsu.mcis.cs408.tabcalculator_converter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.tabcalculator_converter.Model.TipModel;
import edu.jsu.mcis.cs408.tabcalculator_converter.databinding.TipCalculatorFragmentBinding;


public class TipFragment extends Fragment {
    public static final String ARG_ID = "id";

    private TipModel tipModel;
    private TipCalculatorFragmentBinding tipBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        tipBinding = TipCalculatorFragmentBinding.inflate(getLayoutInflater(), container, false);
        return tipBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        tipBinding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipModel = new TipModel();
                String totalBillS = String.valueOf(tipBinding.tBill.getText());
                String percentS = String.valueOf(tipBinding.tipPercent.getText());
                String peopleNumS = String.valueOf(tipBinding.numOfPeople.getText());

                if (totalBillS.isEmpty() || peopleNumS.isEmpty() || percentS.isEmpty()){
                    Toast toast = Toast.makeText(tipBinding.getRoot().getContext(), R.string.tip_empty, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    StringBuilder stringBuilder = new StringBuilder(R.string.tip_response);
                    stringBuilder.append(tipModel.tipCalculate(totalBillS, percentS, peopleNumS)) ;
                    tipBinding.amountText.setText(String.valueOf(stringBuilder));
                }
            }
        });
    }
}

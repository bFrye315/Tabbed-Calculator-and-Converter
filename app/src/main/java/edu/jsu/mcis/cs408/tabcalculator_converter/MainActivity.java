package edu.jsu.mcis.cs408.tabcalculator_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.jsu.mcis.cs408.tabcalculator_converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
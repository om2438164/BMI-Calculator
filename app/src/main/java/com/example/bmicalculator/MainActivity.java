package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult, bmiresult;
        EditText edtWeight, edtheightft, edttheightin;
        Button btnCalculate;
        LinearLayout llMain;
        edtWeight = findViewById(R.id.edtweight);
        edtheightft = findViewById(R.id.edtheightft);
        edttheightin = findViewById(R.id.edtheightin);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);
        bmiresult = findViewById(R.id.bmiresult);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtheightft.getText().toString());
                int in = Integer.parseInt(edttheightin.getText().toString());

                int totalIn = ft * 12 + in;
                double totalM = totalIn * 0.0254;
                double bmi = wt / (totalM * totalM);
                bmiresult.setText("BMI: " + bmi); // Concatenate the BMI value with the string

                if (bmi > 25) {
                    txtResult.setText("You're Overweight");

                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi < 18) {
                    txtResult.setText("You're Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    txtResult.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });
    }
}

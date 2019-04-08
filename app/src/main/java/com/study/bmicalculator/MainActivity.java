package com.study.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
private EditText txtHeight,txtWeight;
private Button btnCalculate;
private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItems();
    }

    private void initItems(){
        txtHeight = findViewById(R.id.txt_height);
        txtWeight = findViewById(R.id.txt_weight);
        txtResult = findViewById(R.id.txt_result);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate(){
        float height = Float.parseFloat(txtHeight.getText().toString())/100;
        float weight = Float.parseFloat(txtWeight.getText().toString());
        float result = weight/(height*height);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        result = Float.parseFloat(df.format(result));
        txtResult.setText(""+result);

        if (result<18.5){
            Toast.makeText(MainActivity.this,"Underweight",Toast.LENGTH_LONG).show();
        }
        else if (result>=18.5 && result<=24.9){
            Toast.makeText(MainActivity.this,"Normal Weight",Toast.LENGTH_LONG).show();
        }
        else if (result>=25 && result<=29.9){
            Toast.makeText(MainActivity.this,"Overweight",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Obesity",Toast.LENGTH_LONG).show();
        }
    }
}

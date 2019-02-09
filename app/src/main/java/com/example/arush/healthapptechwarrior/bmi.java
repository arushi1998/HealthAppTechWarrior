package com.example.arush.healthapptechwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        TextView bmiTextView = findViewById(R.id.bmiTextView);
          int  height = Integer.parseInt(details.height.getText().toString());
        int  weight = Integer.parseInt(details.weight.getText().toString());
        int bmiValue = (int) (0.025*0.025*height*height/weight);
        bmiTextView.setText("Your BMI is:\n" + Integer.toString(bmiValue));

    }
}

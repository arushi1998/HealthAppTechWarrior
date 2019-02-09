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
          double  h = Integer.parseInt(details.height.getText().toString());
        double  w = Integer.parseInt(details.weight.getText().toString());
        double temp= w/(h*h);
        double bmiValue =  (temp/(0.025*0.025));

        TextView rec = findViewById(R.id.rec);
        //int bmi = (int)bmiValue;

        bmiTextView.setText("Your BMI is:\n" + Double.toString(bmiValue));

        if (bmiValue<18.5){
            rec.setText("Under Weight\n You should eat more of Oats, Bananas,Oranges.");
        }
        else if (bmiValue>18.5&&bmiValue<24.9){
            rec.setText("Normal Weight\n You have perfect BMI");
        }
        else if (bmiValue>25&&bmiValue<29.9){
            rec.setText("Over Weight\n You should exercise and eat more of nuts, seeds, cauliflower.");
        }
        else if (bmiValue>30){
            rec.setText("Obesity\n You are at high risk \n You should exercise and eat green vegetables");
        }

    }
}

package com.example.arush.healthapptechwarrior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class two_buttons extends AppCompatActivity {

    TextView sleepEdit;
    public void calcBMI (View view) {
        Intent intent1 = new Intent(this, bmi.class);
        startActivity(intent1);
    }

    public void calcSteps (View view) {
        Intent intent2 = new Intent(this, Steps.class);
        startActivity(intent2);
    }
    public void calorie (View view) {
        Intent intent3 = new Intent(this, calorie.class);
        startActivity(intent3);
    }

    public void valuePassed(View view) {
        if(Integer.parseInt(sleepEdit.getText().toString())<7)
        Toast.makeText(this, "You should sleep for 7 or more Hours", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "PERFECT", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_buttons);

        sleepEdit = findViewById(R.id.sleepEDIT);
    }
}

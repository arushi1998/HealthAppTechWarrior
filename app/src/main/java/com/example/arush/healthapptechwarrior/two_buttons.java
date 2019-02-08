package com.example.arush.healthapptechwarrior;

import android.content.Intent;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class two_buttons extends AppCompatActivity {

    public void calcBMI (View view) {
        Intent intent1 = new Intent(this, bmi.class);
        startActivity(intent1);
    }

    public void calcSteps (View view) {
        Intent intent2 = new Intent(this, steps.class);
        startActivity(intent2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_buttons);
    }
}

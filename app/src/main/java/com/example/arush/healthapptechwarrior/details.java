package com.example.arush.healthapptechwarrior;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class details extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static EditText age,height,weight;
    RadioGroup group;
    public static String g="",lifestyle;
    public void maleButton(View view){
        g="m";
    }
    public void femaleButton(View view){
        g="f";
    }
    public void submit(View view){
        SharedPreferences.Editor editor=getSharedPreferences("DETAILS",MODE_PRIVATE).edit();
        editor.putString("AGE",age.getText().toString());
        editor.putString("HEIGHT",height.getText().toString());
        editor.putString("WEIGHT",weight.getText().toString());
        editor.putString("GENDER",g);
        editor.putString("LIFESTYLE",lifestyle);
        editor.apply();
        Intent intent = new Intent(this,two_buttons.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        age= findViewById(R.id.ageEditText);
        height=findViewById(R.id.heightEditText);
        weight=findViewById(R.id.weightEditText);
        LinearLayout ll=findViewById(R.id.ll);
        group=findViewById(R.id.rg);
        group.clearCheck();
        sharedPreferences=getSharedPreferences("DETAILS",MODE_PRIVATE);
        String age=sharedPreferences.getString("AGE","");

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                switch (i)
                {
                    case (R.id.radioButtonDesk):
                        lifestyle = "desk";
                        break;
                    case (R.id.radioButtonLight):
                        lifestyle ="light";
                        break;
                    case (R.id.radioButtonHeavy):
                        lifestyle = "heavy";
                        break;
                }
            }
        });

        if(age!=""){

         //   Toast.makeText(this, "PREVIOUS DATA IS ALREADY STORED", Toast.LENGTH_LONG).show();

            new CountDownTimer(5000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
//                    Intent intent = new Intent(getBaseContext(),two_buttons.class);
//                    startActivity(intent);
                }
            }.start();

        }
    }
}

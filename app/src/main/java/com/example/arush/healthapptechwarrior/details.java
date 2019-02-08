package com.example.arush.healthapptechwarrior;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class details extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText age,height,weight;
    public void submit(View view){
        SharedPreferences.Editor editor=getSharedPreferences("DETAILS",MODE_PRIVATE).edit();
        editor.putString("AGE",age.getText().toString());
        editor.putString("HEIGHT",height.getText().toString());
        editor.putString("WEIGHT",weight.getText().toString());
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        age= findViewById(R.id.ageEditText);
        height=findViewById(R.id.heightEditText);
        weight=findViewById(R.id.weightEditText);
        sharedPreferences=getSharedPreferences("DETAILS",MODE_PRIVATE);
        String age=sharedPreferences.getString("AGE","");
//        if(age!=""){
//            Intent intent = new Intent(this,.class);
//            startActivity(intent);
//        }



    }
}

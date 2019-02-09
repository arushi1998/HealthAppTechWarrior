package com.example.arush.healthapptechwarrior;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class calorie extends AppCompatActivity {
    String  calorie ="";

    public class Download extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {

            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try{
                url=new URL(strings[0]);
                urlConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                int data = reader.read();
                while (data!=-1){
                    char current= (char)data;
                    result+=current;
                    data=reader.read();
                }
                return result;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        TextView tv= findViewById(R.id.calorieTextView);

        int feet= Integer.valueOf(details.height.getText().toString())/12;
        int inch= Integer.valueOf(details.height.getText().toString())%12;
        double pound= Integer.valueOf(details.weight.getText().toString())/0.45;
        int poundRound= (int) pound;
        Download task = new Download();
        String result = null;
        String feetString= Integer.toString(feet);
        String PString= Integer.toString(poundRound);
        double cm = Integer.valueOf(details.height.getText().toString())*2.54;
        int cmIn=(int) cm;
        String cmString= Double.toString(cmIn);

        try {
            result = task.execute("view-source:https://www.calculator.net/calorie-calculator.html?ctype=standard&cage="+
                    details.age.getText().toString() +"&csex="+ details.g +"&cheightfeet="+ feetString
                    +"&cheightinch="+ Integer.toString(inch) +"1&cpound="+ PString +
                    "&cheightmeter="+ cmString +"&ckg="+ details.weight.getText().toString()
                    +"&cactivity=1.465&cmop=0&coutunit=c&cformula=m&cfatpct=20&printit=0&x=76&y=11/").get();

            String[] splitResult = result.split("Fitness and Health Calculators");
            Pattern p = Pattern.compile("<div class=\"verybigtext\"><b>\"(.*?)\"</b> <span class=\"smalltext\">100%");
            Matcher m = p.matcher(splitResult[1]);
            while (m.find()) {
                calorie =m.group(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        tv.setText(calorie);
    }
}

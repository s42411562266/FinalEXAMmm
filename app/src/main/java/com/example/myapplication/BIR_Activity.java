package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BIR_Activity extends AppCompatActivity {
    private TextView tx6,tx8,wei,hei;
    private EditText bmr,age;
    private int weight,height,male,female,Age;
    private Button mail;
    private String mailAddr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bir_layout);
        tx6=findViewById(R.id.BW);
        tx8=findViewById(R.id.BH);
        wei=findViewById(R.id.textView9);
        age=findViewById(R.id.editText5);
        hei=findViewById(R.id.BBMR);
        mail=findViewById(R.id.button9);
        mail.setVisibility(View.INVISIBLE);
        //bmr=findViewById(R.id.editText8);
        Bundle bundle=this.getIntent().getExtras();
        weight=bundle.getInt("weight");
        height=bundle.getInt("height");
        mailAddr=bundle.getString("email");
        tx6.setText("Body Weight: "+bundle.getInt("weight"));
        tx8.setText("Body Height: "+bundle.getInt("height"));
    }
    public void Back(View v){
        finish();
    }
    String ans;
    public void Cal(View v){
        ans="Your Body Mass Index:";
        double BMI=(double)weight/Math.pow((double)height/100,2);
        ans+=("\n"+BMI);
        wei.setTextSize(25);

        if(BMI<=16){
            ans+=("(severely underweight)");
            wei.setTextColor(Color.MAGENTA);
        }

        else if(BMI>=16&&BMI<=18.5){
            ans+=("(underweight)");
            wei.setTextColor(Color.BLUE);
        }

        else if(BMI>=18.5&&BMI<=25){
            ans+=("(normal)");
            wei.setTextColor(Color.GREEN);
        }

        else if(BMI>=25&&BMI<=30){
            wei.setTextColor(Color.rgb(255,165,0));
            ans+=("(overweight)");
        }

        else if(BMI>=30&&BMI<=35){
            ans+=("(moderately obese)");
            wei.setTextColor(Color.rgb(165,42,42));
        }

        else{
            ans+=("(severely obese)");
            wei.setTextColor(Color.RED);
        }

        wei.setText(ans);
        hei.setTextSize(20);
        hei.setTextColor(Color.BLUE);
        double BMR;
        if(male==1){
            BMR=(13.4*(double)weight)+(4.8*(double)(height/100))-(5.7*(double)(Age))+88.4;
        }
        else
            BMR=(9.3*(double)weight)+(3.0*(double)(height/100))-(4.3*(double)(Age))+447.6;
        String bmr="Basal Metabolic Rate\n"+BMR+" Kacl";
        hei.setText(bmr);
        mail.setVisibility(View.VISIBLE);

    }

    public void sendmail(View v){
        Intent mail=new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",mailAddr,null));
        mail.putExtra(Intent.EXTRA_SUBJECT,"BMI alert");
        mail.putExtra(Intent.EXTRA_TEXT,ans);
        startActivity(Intent.createChooser(mail,"sendmail..."));
    }
}





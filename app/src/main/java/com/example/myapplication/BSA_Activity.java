package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BSA_Activity extends AppCompatActivity {
    private TextView tx6,tx8,result;
    private EditText bmr;
    private int male,female,weight,height;
    private double BMR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bsa_layout);
        tx6=findViewById(R.id.textView6);
        tx8=findViewById(R.id.textView8);
        bmr=findViewById(R.id.editText8);
        result=findViewById(R.id.textView10);
        Bundle bundle=this.getIntent().getExtras();
        weight=bundle.getInt("weight");
        height=bundle.getInt("height");
        male=bundle.getInt("male");
        female=bundle.getInt("female");
        tx6.setText("Body Weight: "+bundle.getInt("weight"));
        tx8.setText("Body Height"+bundle.getInt("height"));
    }

    public void CalBSA(View v){
        double bsa,ocr;
        String ans="Your\n";
        BMR=Double.parseDouble(bmr.getText().toString());
        if(female==1){
             bsa=0.000975382*Math.pow((double)weight,0.46)*Math.pow((double)(height/100),1.08);
             ocr=209*BMR*bsa/(double)60;
        }
        else{
            bsa=0.000579479*Math.pow((double)weight,0.38)*Math.pow((double)(height/100),1.24);
            ocr=209*BMR*bsa/(double)60;
        }

        ans+=("Body surface area: "+bsa+"m^2\nOxygen Consume Rate: "+ocr+" ml/min");
        result.setTextSize(25);
        result.setTextColor(Color.GREEN);
        result.setText(ans);
    }

    public void Close(View v){
        finish();
    }
}

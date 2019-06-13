package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText name,email,weight,height;
    private RadioButton male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        weight=findViewById(R.id.editText3);
        height=findViewById(R.id.editText4);
        male=findViewById(R.id.radioButton3);

    }

    public void DoBIR(View v){
        Intent intent=new Intent();
        intent.setClass(this,BIR_Activity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("weight",Integer.parseInt(weight.getText().toString()));
        bundle.putInt("height",Integer.parseInt(height.getText().toString()));
        bundle.putString("email",email.getText().toString());
        if(male.isChecked()){
            bundle.putInt("male",1);
            bundle.putInt("female",0);
        }
        else{
            bundle.putInt("male",0);
            bundle.putInt("female",1);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void DoBSA(View v){
        Intent intent=new Intent();
        intent.setClass(this,BSA_Activity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("weight",Integer.parseInt(weight.getText().toString()));
        bundle.putInt("height",Integer.parseInt(height.getText().toString()));
        bundle.putString("email",email.getText().toString());
        if(male.isChecked()){
            bundle.putInt("male",1);
            bundle.putInt("female",0);
        }
        else{
            bundle.putInt("male",0);
            bundle.putInt("female",1);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void close(View v){
        finish();
    }
}

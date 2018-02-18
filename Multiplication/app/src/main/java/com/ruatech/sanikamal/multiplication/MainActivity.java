package com.ruatech.sanikamal.multiplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onAddClick(View view){
        if(view.getId()==R.id.BTAdd){
            EditText editText=findViewById(R.id.TFnumber1);
            EditText editText2=findViewById(R.id.TFnumber2);
            TextView textView=findViewById(R.id.TVresult);
            double num1=Double.parseDouble(editText.getText().toString());
            double num2=Double.parseDouble(editText2.getText().toString());
            double result=num1*num2;
            textView.setText(""+result);


        }

    }
}

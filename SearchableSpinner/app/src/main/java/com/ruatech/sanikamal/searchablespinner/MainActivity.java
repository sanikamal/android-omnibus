package com.ruatech.sanikamal.searchablespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=(Spinner)findViewById(R.id.spinner_search);
//        Creating ArrayAdapter using the string array default
        ArrayAdapter<CharSequence> adapter=
                ArrayAdapter.createFromResource(this,R.array.fruits_name,android.R.layout.simple_spinner_item);
//        specify layout to be used when list of choice appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent View view, int position long id){
        String selectedItem=parent.getItemAtPosition(position).toString();
        switch (selectedItem){
            case "Select one Fruit":
                break;
            case "Apple":
                Toast.makeText(getApplicationContext(),selectedItem,Toast.LENGTH_SHORT).show();
                break;

        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }

}

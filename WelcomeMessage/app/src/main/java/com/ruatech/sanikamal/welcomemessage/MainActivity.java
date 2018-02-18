package com.ruatech.sanikamal.welcomemessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView msgTextView;
    EditText userInput;
    Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTextView = findViewById(R.id.messageTextView);
        userInput = findViewById(R.id.userInputEditText);
        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button on press method
                String userName=userInput.getText().toString();
                Intent intent=new Intent(MainActivity.this,messageActivity.class);
                intent.putExtra("PERSON_NAME",userName);
                startActivity(intent);

            }
        });
    }
}

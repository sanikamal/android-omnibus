package com.ruatech.sanikamal.welcomemessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class messageActivity extends AppCompatActivity {
    TextView showWelcomeMessage;
    Button goToWishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        showWelcomeMessage=findViewById(R.id.welcomeTextView);
        goToWishList=findViewById(R.id.goToWiseListButton);
        goToWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(messageActivity.this,WishListActivity.class);
                startActivity(intent);

            }
        });
        showWelcomeMessage.setText("WELCOME!!\n"+getIntent().getStringExtra("PERSON_NAME"));
    }
}

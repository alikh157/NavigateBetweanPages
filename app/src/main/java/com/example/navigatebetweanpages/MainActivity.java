package com.example.navigatebetweanpages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    Button second= findViewById(R.id.second);
    second.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(MainActivity.this,dialPage.class);
            startActivity(i);
        }
    });
    Button first=findViewById(R.id.first);
    first.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i2=new Intent(MainActivity.this,profilePage.class);
            startActivity(i2);
        }
    });
    }
}

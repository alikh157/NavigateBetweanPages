package com.example.navigatebetweanpages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dialPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_page);

        Button btnDial= findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
        EditText dialEdt=findViewById(R.id.dialEdt);
        @Override
            public void onClick(View view) {
        String D="tel:"+dialEdt.getText().toString();
                Intent inerw=new Intent(Intent.ACTION_DIAL, Uri.parse(D));
                startActivity(inerw);
            }
        });
    }

}

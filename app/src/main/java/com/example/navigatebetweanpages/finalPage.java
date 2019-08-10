package com.example.navigatebetweanpages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class finalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        final TextView tvNa=findViewById(R.id.tvNa);
        TextView tvFa=findViewById(R.id.tvFa);
        TextView tvPh=findViewById(R.id.tvPh);
        TextView tvAd=findViewById(R.id.tvAd);
        TextView tvAg=findViewById(R.id.tvAg);
        Intent i=getIntent();
        tvNa.setText(i.getStringExtra("Name"));
        tvFa.setText(i.getStringExtra("Family"));
        tvAg.setText(i.getStringExtra("Age"));
        tvPh.setText(i.getStringExtra("Phone"));
        tvAd.setText(i.getStringExtra("Address"));
        Button btnConfirm=findViewById(R.id.btnConfirm);
        Button btnEdit=findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(finalPage.this,profilePage.class);
                startActivity(back);
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(finalPage.this,profilePage.class);
                intent.putExtra("fine","dear"+tvNa.getText().toString()+"your data was saved!");
                startActivity(intent);
            }
        });

    }
}

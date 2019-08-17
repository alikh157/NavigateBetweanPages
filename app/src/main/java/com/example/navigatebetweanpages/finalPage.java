package com.example.navigatebetweanpages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class finalPage extends AppCompatActivity {
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        final TextView tvNa=findViewById(R.id.tvNa);
//    --------------------
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        drawer=findViewById(R.id.drw);
//    -------------------------
        Button F = findViewById(R.id.F);
        Button S = findViewById(R.id.S);
        Button T = findViewById(R.id.T);
        //-------------
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
//                Intent back=new Intent(finalPage.this,profilePage.class);
//                startActivity(back);
            finish();
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
        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(finalPage.this, profilePage.class);
                startActivity(i2);
            }
        });
        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(finalPage.this, finalPage.class);
                startActivity(i2);
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(finalPage.this, dialPage.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(Gravity.RIGHT);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

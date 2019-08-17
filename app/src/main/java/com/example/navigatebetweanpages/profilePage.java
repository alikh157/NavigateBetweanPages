package com.example.navigatebetweanpages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class profilePage extends AppCompatActivity {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        Button btnReview=findViewById(R.id.btnReview);
        final EditText edtName=findViewById(R.id.edtName);
        final EditText edtFamily=findViewById(R.id.edtFamily);
        final EditText edtPhone=findViewById(R.id.edtPhone);
        final EditText edtAge=findViewById(R.id.edtAge);
        final EditText edtAddress=findViewById(R.id.edtAddress);
        //    --------------------
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        drawer=findViewById(R.id.drw);
//    -------------------------
        Button F = findViewById(R.id.F);
        Button S = findViewById(R.id.S);
        Button T = findViewById(R.id.T);
//  -------------
        TextView tv=findViewById(R.id.tv);
        Intent intent=getIntent();
        tv.setText(intent.getStringExtra("fine"));
        edtName.setText(PreferenceManager.getDefaultSharedPreferences(profilePage.this).getString("Name","EnterName"));
        edtFamily.setText(PreferenceManager.getDefaultSharedPreferences(profilePage.this).getString("Family","EnterFamily"));
        edtPhone.setText(PreferenceManager.getDefaultSharedPreferences(profilePage.this).getString("Phone","EnterPhoneNumber"));
        edtAge.setText(PreferenceManager.getDefaultSharedPreferences(profilePage.this).getString("Age","EnterAge"));
        edtAddress.setText(PreferenceManager.getDefaultSharedPreferences(profilePage.this).getString("Address","EnterAddress"));

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profilePage.this,finalPage.class);
                String Name=edtName.getText().toString();
                String Family=edtFamily.getText().toString();
                String Address=edtAddress.getText().toString();
                String Age=edtAge.getText().toString();
                String Phone=edtPhone.getText().toString();
                intent.putExtra("Name",Name);
                intent.putExtra("Family",Family);
                intent.putExtra("Phone",Phone);
                intent.putExtra("Age",Age);
                intent.putExtra("Address",Address);
                PreferenceManager.getDefaultSharedPreferences(profilePage.this).edit().putString("Name",Name).apply();
                PreferenceManager.getDefaultSharedPreferences(profilePage.this).edit().putString("Family",Family).apply();
                PreferenceManager.getDefaultSharedPreferences(profilePage.this).edit().putString("Phone",Phone).apply();
                PreferenceManager.getDefaultSharedPreferences(profilePage.this).edit().putString("Age",Age).apply();
                PreferenceManager.getDefaultSharedPreferences(profilePage.this).edit().putString("Address",Address).apply();
                startActivity(intent);
            }
        });
        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(profilePage.this, profilePage.class);
                startActivity(i2);
            }
        });
        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(profilePage.this, finalPage.class);
                startActivity(i2);
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profilePage.this, dialPage.class);
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

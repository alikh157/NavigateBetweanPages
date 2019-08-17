package com.example.navigatebetweanpages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class TestRecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler);


        ////////////////////////////////////////////////////////////////////////////////////
        final TextView request=findViewById(R.id.request);
        final Button btnSrc=findViewById(R.id.btnSrc);

        btnSrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String request1=request.getText().toString();
        String address="http://www.omdbapi.com/?s="+request1+"&apikey=70ad462a";
                System.out.println(address);
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(address,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println(response.toString());
                try {
                    JSONObject object=new JSONObject(response.toString());
                    String result=object.getString("Search");
                    JSONArray jsonarray = new JSONArray(result);
                      List<String> list=new ArrayList<String>();
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String Title = jsonobject.getString("Title");
                        list.add(Title);
                    }
        RecyclerView recycler=findViewById(R.id.recycler);
        testRecyclerAdapter adapter=new testRecyclerAdapter(list);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(TestRecycler.this,RecyclerView.VERTICAL,false));
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

        });
            }
        });

    }
}

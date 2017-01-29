package com.shashadhardas.integratevolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import network.NetworkCommunicator;
import network.NetworkException;
import network.NetworkResponse;
import network.volley.RequestResponseListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.doRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkCommunicator net=new NetworkCommunicator(MainActivity.this);
                net.getUser(new NetworkResponse.Listener() {
                    @Override
                    public void onResponse(Object result) {
                        ((TextView)findViewById(R.id.response)).setText("Volley response received!");
                    }
                }, new NetworkResponse.ErrorListener() {
                    @Override
                    public void onError(NetworkException error) {
                        ((TextView)findViewById(R.id.response)).setText("Volley error received!");
                    }
                },"MainActivity");
            }
        });
    }
}

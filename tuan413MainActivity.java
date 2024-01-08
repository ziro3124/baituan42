package com.example.myapplication.tuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class tuan413MainActivity extends AppCompatActivity {
    Button btnGetdata;
    TextView tvKQ;
    Context context=this;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan413_main);
        Tuan41volleyFn volleyFn=new Tuan41volleyFn();
        tvKQ=findViewById(R.id.tuan413TvKQ);
        btnGetdata=findViewById(R.id.tuan413btn);
        btnGetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyFn.getJSONArrayOfObject(context,tvKQ);
            }
        });
    }
}
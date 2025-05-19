package com.ifsc.contaclicks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        Intent intent = getIntent();
        String planeta = intent.getStringExtra("planeta");

        TextView tv = findViewById(R.id.tvnomeplaneta);
        tv.setText(planeta != null ? planeta : "Planeta não informado");
    }
}

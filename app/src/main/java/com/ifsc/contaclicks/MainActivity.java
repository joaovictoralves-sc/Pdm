package com.ifsc.contaclicks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Associando objeto interface a variavel local;
        TextView tv=findViewById(R.id.TextView);
        tv.setText(getString(R.string.app_name));
        Button b=findViewById(R.id.Button);
        b.setOnClickListener(v -> {//Seu codigo lindo aqui
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText( Integer.toString(i)  );
                i++;
            }
        });

    }
}
package com.ifsc.contaclicks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    EditText edpeso, edaltura;
    TextView tvresultadoimc;
    Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ciclo de vida", "metodo onCreate");
        setContentView(R.layout.activity_main);
        edpeso= findViewById(R.id.edpeso);
        edaltura= findViewById(R.id.edaltura);
        tvresultadoimc= findViewById(R.id.tvresultadoimc);
        Button= findViewById(R.id.Button);

        Button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivityB.class);
            String msg = edpeso.getText().toString();
            intent.putExtra("mensagem", msg);
            startActivity(intent);
        });
    }

}
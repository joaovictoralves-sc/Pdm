package com.ifsc.contaclicks;

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
            //calcular o imc
            //recuperar os dados anteriormente

            double peso, altura, imc;
            peso=Double.parseDouble(edpeso.getText().toString());
            altura= Double.parseDouble((edaltura.getText().toString()));
            imc=peso/(altura*altura);
            //formatando numero ##,##
            DecimalFormat decimalformat = new DecimalFormat("##.##");

            tvresultadoimc.setText(decimalformat.format(imc));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo de vida", "metodo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo de vida", "metodo onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclo de vida", "metodo onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo de vida", "metodo onPause");

    }
}
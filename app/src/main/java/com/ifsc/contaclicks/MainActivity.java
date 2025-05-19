package com.ifsc.contaclicks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int i=0;
    EditText edpeso,edaltura;
    TextView tvresulado;
    Button buttonCalcular,buttonNextImage;
    ImageView imageView;
    Integer imagens[] =new Integer[] { R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho
    };
    int posicao=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ciclo de vida","metodo onCreate");
        setContentView(R.layout.activity_main);
        edpeso=findViewById(R.id.edpeso);
        edaltura=findViewById(R.id.edaltura);
        tvresulado=findViewById(R.id.tvresultadoimc);
        buttonCalcular=findViewById(R.id.button);
        buttonNextImage=findViewById(R.id.button2);
        imageView=findViewById(R.id.imageView);

        //define um tratamento para o click do botão
        buttonCalcular.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), MainActivityB.class);
            String msg= edpeso.getText().toString();
            intent.putExtra("mensagem", msg);
            startActivity(intent);
        });
        buttonNextImage.setOnClickListener(v -> {
            imageView.setImageResource(imagens[posicao]);
            if (posicao < imagens.length-1) {
                posicao++;
            }else{
                posicao=0;
            }

        });


    }

}
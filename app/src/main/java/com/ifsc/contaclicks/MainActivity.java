package com.ifsc.contaclicks;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Exemplo de contador
    Integer i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Certifique-se de que o nome do XML seja activity_main.xml

        // Referenciando os elementos da tela
        ImageView imageView2 = findViewById(R.id.imageView2);
        TextView textView = findViewById(R.id.textView);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        EditText editTextText6 = findViewById(R.id.editTextText6);
        EditText editTextText7 = findViewById(R.id.editTextText7);

        // Exemplo de uso
        textView.setText("Bem-vindo!");
        textView4.setText("Nome:");
        textView5.setText("Sobrenome:");
    }
}

package com.ifsc.contaclicks;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PlanetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planeta);

        Bundle bundle = getIntent().getExtras();
        Planeta p = (Planeta) bundle.getSerializable("planeta");

        ImageView imageView = findViewById(R.id.imageViewPlaneta);
        TextView textView = findViewById(R.id.tvNomePlaneta);

        imageView.setImageResource(p.imagem); // Correção do nome do método
        textView.setText(p.nome); // Correção: era "TextView.setText"
    }
}

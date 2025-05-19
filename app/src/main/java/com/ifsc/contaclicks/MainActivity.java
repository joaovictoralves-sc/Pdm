package com.ifsc.contaclicks;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);

        PlanetaAdapter planetaAdapter = new PlanetaAdapter(
                this,
                R.layout.item_lista,
                new DAOPlaneta().listplanetas
        );

        lv.setAdapter(planetaAdapter);
    }
}

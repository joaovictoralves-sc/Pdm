package com.ifsc.contaclicks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);

        DAOPlaneta dao = new DAOPlaneta();
        PlanetaAdapter planetaAdapter = new PlanetaAdapter(
                this,
                R.layout.item_lista,
                dao.getListplanetas()
        );

        lv.setAdapter(planetaAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Planeta planetaSelecionado = dao.getListplanetas().get(position);

                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                intent.putExtra("planeta", planetaSelecionado.getNome());
                startActivity(intent);
            }
        });
    }
}

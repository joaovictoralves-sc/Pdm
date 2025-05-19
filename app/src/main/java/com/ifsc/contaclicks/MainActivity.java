package com.ifsc.contaclicks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int i=0;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv= findViewById(R.id.listview);

        PlanetaDao planetaDao=new PlanetaDao();


        AdapterPlaneta ap=new AdapterPlaneta(this,
                R.layout.item_lista,
                planetaDao.getPlatenas());
        lv.setAdapter(ap);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta p = planetaDao.getPlatenas().get(position);

                Intent i = new Intent(getApplicationContext(),PlanetaActivity.class);
                i.putExtra("planeta",p);
                startActivity(i);
            }
        });
    }
}
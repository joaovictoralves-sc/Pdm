package com.ifsc.contaclicks;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    TextView tvLatitude,tvLongitude,tvStatus;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLatitude=findViewById(R.id.tvLatitude);
        tvLongitude=findViewById(R.id.tvLongitude);
        tvStatus=findViewById(R.id.tvStatus);
        button = findViewById(R.id.button);
        locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);

        button.setOnClickListener(v->{
            getLocalizacao();
        });
    }
    @SuppressLint("MissingPermission")
    public void getLocalizacao(){
        if (checaESolicitaPermicao() ) {
            tvLatitude.setText("Buscando Localizacao");
            Location l =locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (l!=null) {
                tvLatitude.setText(Double.toString(l.getLatitude()));
                tvLongitude.setText(Double.toString(l.getLongitude()));
            }else {
                tvLatitude.setText("Sem localizacao");
            }
        }else{
            tvLatitude.setText("Permissão negada");
        }
    }

    public boolean checaESolicitaPermicao(){
        //Verifica se tem e caso não pede a permisão
        tvLatitude.setText("Checando Permissão");
        if(
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        !=PackageManager.PERMISSION_GRANTED
                        ||
                        ActivityCompat.checkSelfPermission(this,
                                Manifest.permission.ACCESS_COARSE_LOCATION)
                                !=PackageManager.PERMISSION_GRANTED
        )
        {//Código if se nenhuma das permisssões tiver sido concedida
            tvLatitude.setText("Solicitando");
            ActivityCompat.requestPermissions(
                    this,
                    new String[] { Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    },
                    PackageManager.PERMISSION_GRANTED
            );
            return  false;
        }else{
            return true;
        }

    }


}
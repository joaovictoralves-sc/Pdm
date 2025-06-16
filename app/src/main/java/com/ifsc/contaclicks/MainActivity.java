package com.ifsc.contaclicks;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PackageManager pm;
    List<ApplicationInfo> applicationInfoList;
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listView);
        pm=getPackageManager();



        applicationInfoList=pm.getInstalledApplications(PackageManager.MATCH_ALL);

        AppAdapter appAdapter = new AppAdapter(this,R.layout.app_item,applicationInfoList);
        lv.setAdapter(appAdapter);


    }
}
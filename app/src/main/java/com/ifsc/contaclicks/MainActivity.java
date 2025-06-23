package com.ifsc.contaclicks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PackageManager pm;

    List<ApplicationInfo> applicationInfosList;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listView);

        pm = getPackageManager();

        //applicationInfosList = pm.getInstalledApplications(PackageManager.MATCH_ALL);

        Intent intentFilter = new Intent(Intent.ACTION_MAIN);
        intentFilter.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> lRInfo = pm.queryIntentActivities(intentFilter, 0);
        applicationInfosList = new ArrayList<>();

        for(ResolveInfo r:lRInfo){

            applicationInfosList.add(r.activityInfo.applicationInfo);

        }

        AppAdapter appAdapter = new AppAdapter(this, R.layout.app_item,applicationInfosList);
        lv.setAdapter(appAdapter);

        lv.setOnItemClickListener((adapterView, view, position, l) -> {

            ApplicationInfo appInfo = (ApplicationInfo)adapterView.getItemAtPosition(position);
            Intent i = pm.getLaunchIntentForPackage(appInfo.packageName);
            if(i!=null) {
                startActivity(i);
            }
            else{
                Toast.makeText(getApplicationContext(), "App não lançável", Toast.LENGTH_LONG);
            }
        });
    }

}
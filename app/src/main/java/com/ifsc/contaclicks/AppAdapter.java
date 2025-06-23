package com.ifsc.contaclicks;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    int mresource;

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects){
        super(context, resource, objects);
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View v = layoutInflater.inflate(mresource, parent, false);
        ImageView imageView = v.findViewById(R.id.imageView2);
        TextView tv = v.findViewById(R.id.textView);
        LinearLayout ll = v.findViewById(R.id.linearLayout);

        ApplicationInfo appInfo = getItem(position);

        tv.setText(appInfo.loadLabel(getContext().getPackageManager()));
        imageView.setImageDrawable(appInfo.loadIcon(getContext().getPackageManager()));

        TextView tvPackageName = new TextView(getContext());
        tvPackageName.setText("Pacote: " +appInfo.packageName);

        TextView tvClassName = new TextView(getContext());
        tvClassName.setText("Classe: "+ appInfo.className);

        TextView tvDataDir = new TextView(getContext());
        tvDataDir.setText("Diretorio: "+ appInfo.dataDir);

        TextView tvTaskAff = new TextView(getContext());
        tvTaskAff.setText("Source dir: "+ appInfo.sourceDir);


        ll.addView(tvPackageName);
        ll.addView(tvClassName);
        ll.addView(tvDataDir);
        ll.addView(tvTaskAff);

        return v;
    }

}
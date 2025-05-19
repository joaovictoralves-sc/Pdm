package com.ifsc.contaclicks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    private final Context mContext;
    private final int mResource;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(mResource, parent, false);

        Planeta planeta = getItem(position);

        TextView tv = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        if (planeta != null) {
            tv.setText(planeta.getNome());
            imageView.setImageResource(planeta.getFoto());
        }

        return view;
    }
}

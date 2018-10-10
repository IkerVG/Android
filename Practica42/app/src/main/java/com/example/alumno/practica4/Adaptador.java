package com.example.alumno.practica4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends ArrayAdapter<DataItem> {
    Context context;
    int layoutResourceId;
    List<DataItem> data = null;

    public Adaptador(@NonNull Context context, int resource, @NonNull List<DataItem> objects) {
        super(context, resource, objects);
        this.layoutResourceId= resource;
        this.context = context;
        this.data = objects;
    }
    static class DataHolder{
        ImageView img;
        TextView text;
        CheckBox checkBox;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        DataHolder holder = null;

    }
}

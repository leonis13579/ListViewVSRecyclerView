package com.example.listviewvsrecyclerview.ui.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewvsrecyclerview.data.models.Item;

public class ListViewAdapter extends ArrayAdapter<Item> {


    public ListViewAdapter(@NonNull Context context, int resource, @NonNull Item[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        ((TextView) v).setText(getItem(position).getValue());

        return v;
    }
}

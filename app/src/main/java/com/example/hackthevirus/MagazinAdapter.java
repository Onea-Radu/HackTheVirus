package com.example.hackthevirus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MagazinAdapter extends ArrayAdapter<Magazin> {


    int position;


    public void selectedItem(int position)
    {
        this.position = position;
    }

    public MagazinAdapter(Context context, ArrayList<Magazin> details) {
        super(context,R.layout.row_item,details);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater reportsInflater = LayoutInflater.from(getContext());
        View reportView = reportsInflater.inflate(R.layout.row_item,parent,false);

        TextView shopName = (TextView) reportView.findViewById(R.id.shopName);
        TextView shopAdress = (TextView) reportView.findViewById(R.id.shopAdress);
        TextView shopNumber = (TextView) reportView.findViewById(R.id.shopNumber);

        shopName.setText(Objects.requireNonNull(getItem(position)).nume);
        shopAdress.setText(Objects.requireNonNull(getItem(position)).adresa);
        shopNumber.setText(Objects.requireNonNull(getItem(position)).numar);

        return reportView;
        }

}

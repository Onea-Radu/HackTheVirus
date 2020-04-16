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

public class MagazinAdapter extends ArrayAdapter<String> {


    int position;


    public void selectedItem(int position)
    {
        this.position = position;
    }

    public MagazinAdapter(Context context, ArrayList<String> details) {
        super(context,R.layout.row_item,details);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater reportsInflater = LayoutInflater.from(getContext());
        View reportView = reportsInflater.inflate(R.layout.row_item,parent,false);

        String singleReportItem = getItem(position);
        TextView shopName = (TextView) reportView.findViewById(R.id.shopName);
        TextView shopAdress = (TextView) reportView.findViewById(R.id.shopAdress);
        TextView shopNumber = (TextView) reportView.findViewById(R.id.shopNumber);

        return reportView;
        }

}

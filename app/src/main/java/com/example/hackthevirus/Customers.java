package com.example.hackthevirus;


import android.nfc.Tag;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Customers {
    public ConcurrentLinkedQueue<Date> customers;
    int minutes;
    Runnable r;
    TextView textView;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Customers(TextView tv, int min){
        super();
        Log.d( "TAG","am ajuns aici*************");
        this.customers=new ConcurrentLinkedQueue<>();
        this.minutes=min;
        this.textView=tv;
        this.r=()->{


                Date d=new Date();
                while (customers.size()!=0 && d.after(customers.peek()))
                    customers.remove();
                Log.d( "TAG","am ajuns si aici*************");


              setTxt();
                textView.postDelayed(r,5000);

        };
        textView.post(r);
        Log.d( "TAG","am ajuns aici*************");

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Customers(TextView tv)
    {
        this(tv,5);
    }
    public void addCustomer(){
        customers.add(new Date(System.currentTimeMillis() +minutes *60* 1000));
        this.setTxt();
    }
    public int getSize(){
        return customers.size();
    }
    public void setTxt(){
        textView.setText(getSize()+"");
    }




}

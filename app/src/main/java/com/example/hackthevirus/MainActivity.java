package com.example.hackthevirus;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthCredential;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String id="15";
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusPlus = findViewById(R.id.plusPlus);
        Button listaMagazine = findViewById(R.id.listaMagazine);
        final TextView numarCurent = findViewById((R.id.numarCurent));
        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        final Customers c=new Customers(numarCurent,database.child(id));

        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        plusPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c.addCustomer();



            }
        });

        listaMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaMagazine.class);
                startActivity(intent);
            }
        });
    }

}


package com.example.hackthevirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusPlus = findViewById(R.id.plusPlus);
        Button listaMagazine = findViewById(R.id.listaMagazine);
        final TextView numarCurent = findViewById((R.id.numarCurent));

        plusPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numarCurent.setText(Integer.parseInt(numarCurent.getText().toString())+1+"");
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


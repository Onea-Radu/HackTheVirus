package com.example.hackthevirus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AfterFirstLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_first_login);
        EditText nume = findViewById(R.id.editText2);
        EditText adresa = findViewById(R.id.editText3);
        Button btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db= FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getUid());
                db.child("nume").setValue(nume.getText().toString());
                db.child("adresa").setValue(adresa.getText().toString());
                finishActivity(RESULT_OK);
            }
        });

    }
}

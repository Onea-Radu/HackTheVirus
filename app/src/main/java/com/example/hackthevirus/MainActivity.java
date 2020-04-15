package com.example.hackthevirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    String id="12";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusPlus = findViewById(R.id.plusPlus);
        Button listaMagazine = findViewById(R.id.listaMagazine);
        final TextView numarCurent = findViewById((R.id.numarCurent));
        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();








        plusPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numarCurent.setText(Integer.parseInt(numarCurent.getText().toString())+1+"");
                database.child(id).child("numar").setValue(numarCurent.getText().toString());



                //pt butonul de login
                List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build());
                int RC_SIGN_IN = 200;
                if(FirebaseAuth.getInstance().getCurrentUser()==null)
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(providers)
                                .build(),
                        RC_SIGN_IN);
                //buton de sign out : FirebaseAuth.getInstance().signOut();
                //final

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


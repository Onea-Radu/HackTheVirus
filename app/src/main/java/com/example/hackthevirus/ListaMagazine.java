package com.example.hackthevirus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaMagazine extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200 && resultCode==RESULT_OK)
        { new Intent();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_magazine);
        final ListView listViewMagazine = (ListView) findViewById(R.id.listViewMagazine);

        Button mapBtn = findViewById(R.id.mapBtn);

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pt butonul de login

                List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build());
                int RC_SIGN_IN = 200;
                if(FirebaseAuth.getInstance().getCurrentUser()==null)//cu asta verifici daca utilizatorul e logat pastreaza starea si dupa ce inchizi aplicatia btw
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

        final ArrayList<Magazin> list = new ArrayList<Magazin>();
        /*for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }*/
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {

                    for (DataSnapshot i : dataSnapshot.getChildren()){
                        Magazin mag = new Magazin();
                        mag.numar = i.child("numar").getValue().toString();
                        mag.adresa = i.child("adresa").getValue().toString();
                        mag.nume = i.child("nume").getValue().toString();
                        list.add(mag);
                    }

                   /* final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, android.R.id.text1, list);
                    listViewMagazine.setAdapter(adapter);*/

                   setLayout(list);
                }
                catch (Exception e){Toast.makeText(getApplicationContext(),"numergesefu",Toast.LENGTH_LONG);}
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void setLayout( ArrayList<Magazin> list){

        final ListAdapter reportAdapter = new MagazinAdapter(this,list);
        ListView reportListView = (ListView)  findViewById(R.id.listViewMagazine);
        reportListView.setAdapter(reportAdapter);
        
        reportListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}

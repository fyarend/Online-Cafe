package com.example.online_cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class EveSiparisGiris extends AppCompatActivity {
    private Button girisButton;
    private TextView registerText;
    private TextView welcomeText;
    private EditText usernmEditText;
    private EditText sifreEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evesiparisgiris);
        girisButton = findViewById(R.id.eLogin_button);
        welcomeText = findViewById(R.id.lWelcome_text);
        usernmEditText = findViewById(R.id.eUsername_area);
        sifreEditText = findViewById(R.id.ePassword_area);

            welcomeText.setText(R.string.welcome_customer);
            girisButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    giris("evesiparis");

                }
            });


            registerText = (TextView) findViewById(R.id.eRegister_text);
            registerText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EveSiparisKayit.class);
                    startActivity(intent);
                }
            });

    }
    private void giris(String path) {
        final String userUsername =  usernmEditText.getText().toString().trim();
        final String userPassword = sifreEditText.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        Query checkEMail = reference.orderByChild("username").equalTo(userUsername);
        checkEMail.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passwordDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    CONST.usersNameAndSurname.setUserNameAndSurname(snapshot
                            .child(userUsername)
                            .child("nameSurname")
                            .getValue(String.class));

                    if (passwordDB.equals(userPassword)) {
                        Toast.makeText(getApplicationContext(),
                                "Giriş Başarılı",
                                Toast.LENGTH_SHORT).show();

                            Intent intentStore = new Intent(getApplicationContext(),
                                    StoreActivity.class);
                            startActivity(intentStore);


                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Kullanıcı Adı yada Şifre Hatalı",
                                Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),
                            "Kullanıcı Adı yada Şifre Hatalı",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}
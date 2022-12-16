package com.example.online_cafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.online_cafe.authentication.Evesiparis;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EveSiparisKayit extends AppCompatActivity {
    private Button registerButton;
    private EditText nameSurnameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText adresEditText;
    private EditText telEditText;
    private String nameSurname;
    private String username;
    private String password;
    private String adres;
    private String tel;
    FirebaseDatabase rootNode;
    private Boolean returnValue = true;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evesipariskayit);
        registerButton = findViewById(R.id.eRegister_button);
        nameSurnameEditText = findViewById(R.id.eName_surname_area);
        usernameEditText = findViewById(R.id.eUsername_area);
        passwordEditText = findViewById(R.id.ePassword_area);
        adresEditText = findViewById(R.id.eAdres);
        telEditText = findViewById(R.id.eTelefon);
        FirebaseApp.initializeApp(getApplicationContext());

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    register("evesiparis");
                }


            private void register(String path) {
                nameSurname = nameSurnameEditText.getText().toString();
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                adres = adresEditText.getText().toString();
                tel = telEditText.getText().toString();
                Evesiparis user = new Evesiparis(nameSurname, username, password,adres,tel);

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference(path);
                reference.child(username).setValue(user);
                if (username.length()<6 && username.length()>20&&nameSurname.length()<6 && nameSurname.length()>20&&password.length()>3&&password.length()<11) {
                    Toast.makeText(getApplicationContext(), "Kullanıcı Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Kullanıcı Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}

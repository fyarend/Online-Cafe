package com.example.online_cafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.online_cafe.authentication.Kurye;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KuryeKayit extends AppCompatActivity {

    private Button registerButton;
    private EditText nameSurnameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private String nameSurname;
    private String username;
    private String password;
    FirebaseDatabase rootNode;
    private Boolean returnValue = true;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuryekayit);
        registerButton = findViewById(R.id.krRegister_button);
        nameSurnameEditText = findViewById(R.id.krName_surname_area);
        usernameEditText = findViewById(R.id.krUsername_area);
        passwordEditText = findViewById(R.id.krPassword_area);
        FirebaseApp.initializeApp(getApplicationContext());

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    register("kurye");
            }

            private void register(String path) {
                nameSurname = nameSurnameEditText.getText().toString();
                username = usernameEditText.getText().toString();
                password = passwordEditText.getText().toString();
                Kurye user = new Kurye(nameSurname, username, password);

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

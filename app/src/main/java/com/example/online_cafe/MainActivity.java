package com.example.online_cafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    private Button customerButton;
    private Button waiterButton;
    private Button evesiparis;
    private Button kuryeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerButton = findViewById(R.id.customer_button);
        waiterButton = findViewById(R.id.waiter_button);
        evesiparis = findViewById(R.id.evesiparisgiris_b);
        kuryeButton = findViewById(R.id.kuryegiris);
        setupPermissions();

        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CONST.userType = "musteri";
                startNewActivity();
            }
        });

        waiterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CONST.userType = "garson";
                startNewActivity();
            }
        });

        evesiparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EveSiparisGiris eveSiparisGiris = new EveSiparisGiris();
                Intent intent = new Intent(getApplicationContext(), eveSiparisGiris.getClass());
                startActivity(intent);

            }
        });

        kuryeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KuryeGiris kuryeGiris = new KuryeGiris();
                Intent intent = new Intent(getApplicationContext(),kuryeGiris.getClass());
                startActivity(intent);
            }
        });

    }

    private void startNewActivity(){
        AuthenticationActivity authenticationActivity = new AuthenticationActivity();
        Intent intent = new Intent(getApplicationContext(),authenticationActivity.getClass());
        startActivity(intent);
    }

    private void setupPermissions(){
        int perm = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        if (perm != PackageManager.PERMISSION_GRANTED){
            makeRequest();
        }

    }

    private void makeRequest() {
        String[] perm = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(this, perm, 111);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        if (requestCode == 111){
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "Kameraya izin vermelisin", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


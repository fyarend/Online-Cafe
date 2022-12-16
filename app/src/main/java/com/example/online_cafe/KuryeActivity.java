package com.example.online_cafe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.online_cafe.products.CategoryFragment;

public class KuryeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurye);
        KuryeEkranFragment fragment = new KuryeEkranFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.kframe_layout_container, fragment)
                .addToBackStack(CategoryFragment.class.getSimpleName())
                .commit();
    }
}
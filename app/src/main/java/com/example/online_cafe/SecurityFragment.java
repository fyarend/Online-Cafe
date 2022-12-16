package com.example.online_cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;


public class SecurityFragment extends Fragment {
    private TextView guvenlik;
    private EditText sifre;
    private Button onayla;
    private Button yorum;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_security, container, false);

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        sifre = view.findViewById(R.id.Guvenliksifre);
        guvenlik = view.findViewById(R.id.success_textView);
        onayla = view.findViewById(R.id.guvenlik_button);
        yorum = view.findViewById(R.id.yorum);
        onayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sifre.length()>3 &&sifre.length()<11)
                {

                    guvenlik.setText("Ödeme Başarılı");

                }
                else
                {
                    guvenlik.setText("Siparişiniz Onaylanamadı" );
                }

            }
        });
        yorum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YorumActivity.class);
                startActivity(intent);
            }
        });


    }



}






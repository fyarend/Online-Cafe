package com.example.online_cafe;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class CreditCardFragment extends Fragment {
    private Button confirmButton;
    private EditText kartno;
    private EditText cvv;
    private EditText kullanmatarihi;
    private TextView onayla;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_credit_card, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        confirmButton = view.findViewById(R.id.confirm_credit_card_button);
        kartno = view.findViewById(R.id.card_number);
        cvv = view.findViewById(R.id.cvv_number);
        kullanmatarihi=view.findViewById(R.id.date_number);
        onayla=view.findViewById(R.id.success_textView);
        confirmButton.setOnClickListener(new View.OnClickListener() {

            @Override

                public void onClick(View v) {
                if (kartno.length() == 16 && cvv.length() == 3 && kullanmatarihi.length() == 5) {
                    SecurityFragment securityFragment = new SecurityFragment();
                    startFragment(securityFragment);
                }
                else {
                    onayla.setText("Lütfen Bilgilerinizi Doğru Giriniz" );
                }
            }

            });
        }

        private void startFragment(Fragment fragment) {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment, "FragmentReplaced")
                    .addToBackStack(null)
                    .commit();

        }



}
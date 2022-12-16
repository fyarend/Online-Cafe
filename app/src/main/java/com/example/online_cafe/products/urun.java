package com.example.online_cafe.products;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.online_cafe.CONST;
import com.example.online_cafe.ChoosePaymentFragment;
import com.example.online_cafe.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class urun extends Fragment {
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_urun, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateUUID();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("orders");
        reference.child(CONST.UUID).child("order").setValue(CONST.listOfOrders);
        CONST.usersNameAndSurname.setTotalAmount(CONST.totalAmount);
        reference.child(CONST.UUID).child("user").setValue(CONST.usersNameAndSurname);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                        ChoosePaymentFragment fragment = new ChoosePaymentFragment();
                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.urun_fragmentContainer,fragment, "FragmentReplaced")
                                .addToBackStack(null)
                                .commit();


                }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    public void generateUUID(){
        UUID uuid = UUID.randomUUID();
        CONST.UUID = uuid.toString();
    }
}

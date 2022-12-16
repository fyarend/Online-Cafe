package com.example.online_cafe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.online_cafe.adapter.CustomerAdapter;
import com.example.online_cafe.adapter.WaiterOrderAdapter;
import com.example.online_cafe.mapper.ProductDataMapper;
import com.example.online_cafe.products.Musteriler;
import com.example.online_cafe.products.ProductData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KuryeEkranFragment extends Fragment {
    private TextView userNameText;
    private TextView adresText;
    private TextView telText;
    private TextView totalAmount;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.kurye_ekrani, container, false);
        return inflater.inflate(R.layout.musteriler_listesi, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        /*
        userNameText = view.findViewById(R.id.kwaiterusername);
        totalAmount = view.findViewById(R.id.kprice_will_pay);
        adresText = view.findViewById(R.id.kadres);
        telText = view.findViewById(R.id.ktelefon);
*/
        super.onViewCreated(view, savedInstanceState);

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("orders/"+ "/order");
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("orders/");
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<Musteriler> orderList = new ArrayList<>();
                    orderList.size();
                    CONST.customerListToFinish.addAll(orderList);
                    RecyclerView recyclerView = view.findViewById(R.id.musteriRec);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(new CustomerAdapter(CONST.customerListToFinish));
                    for (DataSnapshot postSnapshot: task.getResult().getChildren()) {
                        Musteriler musteri = new Musteriler(0, "");
                        musteri.nameSurname = postSnapshot.child("user/userNameAndSurname").getValue().toString();
                        musteri.totalAmount = postSnapshot.child("user/totalAmount").getValue(Long.class);
                        CONST.customerListToFinish.add(musteri);
                    }
                    /*
                    ArrayList<ProductData> orderList = new ArrayList<>();
                    orderList.size();
                    CONST.orderListToFinish.addAll(orderList);
                    RecyclerView recyclerView = view.findViewById(R.id.musteriRec);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(new WaiterOrderAdapter(CONST.orderListToFinish));
                    RecyclerView recyclerView = view.findViewById(R.id.kresultorderrv);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(new WaiterOrderAdapter(CONST.orderListToFinish));
*/
                }
            }
        });

//        DatabaseReference totalAmountReferance = FirebaseDatabase.getInstance().getReference("orders/" + "/user/totalAmount");
//        DatabaseReference totalAmountReferance = FirebaseDatabase.getInstance().getReference("orders/" + "f1b9f0e5-6781-467b-8399-2b72c2430ef4/user/totalAmount");
//        Log.i(totalAmountReferance.toString(),"uyari");

        DatabaseReference totalAmountReferance = FirebaseDatabase.getInstance().getReference().child("orders/");

        totalAmountReferance.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    Log.i(Long.toString(task.getResult().getChildrenCount()),"uyari");
                    for (DataSnapshot postSnapshot: task.getResult().getChildren()) {
                        Log.i( "uyari",postSnapshot.child("user/totalAmount").getValue().toString());
                    }

                    //CONST.waiterTotalAmount = task.getResult().getValue(Long.class);
                    //totalAmount.setText(CONST.waiterTotalAmount.toString());

                }
            }
        });

        DatabaseReference userNameReferance = FirebaseDatabase.getInstance().getReference("orders/"  + "/user/userNameAndSurname");
        userNameReferance.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    CONST.customerUserName = task.getResult().getValue(String.class);
                    //userNameText.setText("Müşteri, " + CONST.customerUserName);
                }
            }
        });

        DatabaseReference adresReferance = FirebaseDatabase.getInstance().getReference("evesiparis/"  + "/user/adres");
        adresReferance.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    CONST.adres = task.getResult().getValue(String.class);
                    //adresText.setText("Müşteri, " + CONST.adres);
                }
            }
        });
        DatabaseReference telReferance = FirebaseDatabase.getInstance().getReference("evesiparis/"  + "/user/tel");
        telReferance.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    CONST.telefon = task.getResult().getValue(String.class);
                    //telText.setText("Müşteri, " + CONST.adres);
                }
            }
        });

    }

}
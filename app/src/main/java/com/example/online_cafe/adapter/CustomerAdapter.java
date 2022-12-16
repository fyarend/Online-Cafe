package com.example.online_cafe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.online_cafe.R;
import com.example.online_cafe.products.Musteriler;


import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>{
    List<Musteriler> list = Collections.emptyList();

    public CustomerAdapter(List<Musteriler> list) {
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomerAdapter.ViewHolder holder, int position) {
        holder.nameSurname.setText(list.get(position).nameSurname);
        //holder.customerImage.setImageResource(list.get(position).);
        holder.customerTotalAmount.setText(list.get(position).totalAmount + "TL");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameSurname;
        ImageView customerImage;
        TextView customerTotalAmount;

        public ViewHolder( View itemView) {
            super(itemView);
            nameSurname = itemView.findViewById(R.id.customer_name);
            customerImage = itemView.findViewById(R.id.customer_image);
            customerTotalAmount = itemView.findViewById(R.id.customer_total_amount);
        }
    }
}

package com.example.online_cafe.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.online_cafe.CONST;
import com.example.online_cafe.ChoosePaymentFragment;
import com.example.online_cafe.CreditCardFragment;
import com.example.online_cafe.R;
import com.example.online_cafe.RegisterActivity;
import com.example.online_cafe.YorumActivity;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {
    private Button fastFoodButton;
    private Button drinkButton;
    private Button dessertButton;
    private Button mealButton;
    private Button orderButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fastFoodButton = view.findViewById(R.id.fast_food_button);
        drinkButton = view.findViewById(R.id.drink_button);
        dessertButton = view.findViewById(R.id.dessert_button);
        mealButton = view.findViewById(R.id.meal_button);
        orderButton = view.findViewById(R.id.confirm_button);

        fastFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setFastFoodItems();
                startFragment(data);
            }
        });

        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setDrinkItems();
                startFragment(data);
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setDessertItems();
                startFragment(data);
            }
        });

        mealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setMealItems();
                startFragment(data);
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CONST.isProductSelected = true;
                startFragment(CONST.listOfOrders);
            }
        });
    }



    private void startFragment(List<ProductData> data) {
        ProductListFragment fragment = new ProductListFragment(data);
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer,fragment, "FragmentReplaced")
                .addToBackStack(null)
                .commit();

    }


    public List<ProductData> setFastFoodItems(){
        List<ProductData> data = new ArrayList<>();

        data.add(new ProductData(R.drawable.hamburger,"Hamburger", (long) 15));
        data.add(new ProductData(R.drawable.pizza,"Pizza", (long) 20));
        data.add(new ProductData(R.drawable.french_fries,"Cips", (long)5));
        data.add(new ProductData(R.drawable.sandwich,"Sandaviç", (long)10));
        data.add(new ProductData(R.drawable.toast,"Tost", (long)10));
        data.add(new ProductData(R.drawable.spaghetti,"Spaghetti", (long)12));
        return data;
    }

    private List<ProductData> setDrinkItems() {
        List<ProductData> data = new ArrayList<>();

        data.add(new ProductData(R.drawable.lemonade,"Limonata", (long)5));
        data.add(new ProductData(R.drawable.coke,"Kola", (long)3));
        data.add(new ProductData(R.drawable.smoothi,"Smoothi", (long)8));
        data.add(new ProductData(R.drawable.orange_juice,"Portakal Suyu", (long)8));
        data.add(new ProductData(R.drawable.coffe,"Kahve", (long)5));
        data.add(new ProductData(R.drawable.tea,"Çay", (long)2));
        data.add(new ProductData(R.drawable.buttermilk,"Ayran", (long)3));
        return data;
    }

    private List<ProductData> setDessertItems() {
        List<ProductData> data = new ArrayList<>();

        data.add(new ProductData(R.drawable.apple_pie,"Elmalı Turta", (long)12));
        data.add(new ProductData(R.drawable.ice_cream,"Dondurma", (long)8));
        data.add(new ProductData(R.drawable.cookie,"Kurabiye", (long)4));
        data.add(new ProductData(R.drawable.pudding,"Pudding", (long)8));
        data.add(new ProductData(R.drawable.pancake,"Pancake", (long)10));
        data.add(new ProductData(R.drawable.baklava,"Baklava", (long)7));
        return data;
    }

    private List<ProductData> setMealItems() {
        List<ProductData> data = new ArrayList<>();
        data.add(new ProductData(R.drawable.lahmacun,"Lahmacun", (long)5));
        data.add(new ProductData(R.drawable.iskender,"İskender", (long)20));
        data.add(new ProductData(R.drawable.adana,"Adana Kebap", (long)15));
        data.add(new ProductData(R.drawable.patlican_kebap,"Patlıcan Kebabı", (long)15));
        data.add(new ProductData(R.drawable.patty,"Börek", (long)12));
        data.add(new ProductData(R.drawable.doner,"Döner", (long)8));
        data.add(new ProductData(R.drawable.rice,"Pilav", (long)5));
        data.add(new ProductData(R.drawable.soup,"Mercimek Çorbası", (long)7));
        data.add(new ProductData(R.drawable.cig_kofte,"Çiğ Köfte", (long)10));
        return data;
    }
}
package com.example.pz11_mdk0103;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Булка", 0, "шт."));
        products.add(new Product("Кефир", 0, "л."));
        products.add(new Product("Полбатона", 0, "шт."));
        products.add(new Product("Картофель", 0, "кг."));
        products.add(new Product("Сахар", 0, "кг."));
        products.add(new Product("Яйца", 0, "шт."));



        ProductAdapter adapter = new ProductAdapter(this, products);

        ListView listView = findViewById(R.id.productListView);
        listView.setAdapter(adapter);
    }
}


package com.example.pz11_mdk0103;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Product product = products.get(position);

        TextView nameView = convertView.findViewById(R.id.productName);
        TextView quantityWithUnitView = convertView.findViewById(R.id.productQuantityWithUnit);
        Button increaseButton = convertView.findViewById(R.id.buttonIncrease);
        Button decreaseButton = convertView.findViewById(R.id.buttonDecrease);

        nameView.setText(product.getName());
        quantityWithUnitView.setText(product.getQuantity() + " " + product.getUnit());

        increaseButton.setOnClickListener(v -> {
            product.setQuantity(product.getQuantity() + 1);
            quantityWithUnitView.setText(product.getQuantity() + " " + product.getUnit());
        });

        decreaseButton.setOnClickListener(v -> {
            if (product.getQuantity() > 0) {
                product.setQuantity(product.getQuantity() - 1);
                quantityWithUnitView.setText(product.getQuantity() + " " + product.getUnit());
            }
        });

        return convertView;
    }

}


package com.example.barangkushopserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.barangkushopserver.Common.Common;
import com.example.barangkushopserver.ViewHolder.OrderDetailAdapter;

public class OrderDetail extends AppCompatActivity {

    TextView order_id, order_phone, order_idgame, order_total, order_catatan, order_date, order_contact;
    String order_id_value = "";
    RecyclerView listProducts;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        order_id = findViewById(R.id.order_id_detail);
        order_phone = findViewById(R.id.order_phone_detail);
        order_idgame = findViewById(R.id.order_idgame_detail);
        order_total = findViewById(R.id.order_total_detail);
        order_catatan = findViewById(R.id.order_catatan_detail);
        order_contact = findViewById(R.id.order_contact_detail);

        listProducts = findViewById(R.id.listOrderDetail);
        listProducts.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listProducts.setLayoutManager(layoutManager);

        if (getIntent() != null)
            order_id_value = getIntent().getStringExtra("OrderId");

        //set Value
        order_id.setText(order_id_value);
        order_phone.setText(Common.currentRequest.getPhone());
        order_total.setText(Common.currentRequest.getTotal());
        order_idgame.setText(Common.currentRequest.getIdgame());
        order_catatan.setText(Common.currentRequest.getCatatan());
        order_contact.setText(Common.currentRequest.getContact());

        OrderDetailAdapter adapter = new OrderDetailAdapter(Common.currentRequest.getProducts());
        adapter.notifyDataSetChanged();
        listProducts.setAdapter(adapter);


    }
}

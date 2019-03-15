package com.example.barangkushopserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.barangkushopserver.Common.Common;
import com.example.barangkushopserver.ViewHolder.OrderDetailAdapter;

public class OrderDetail extends AppCompatActivity {

    TextView order_id, order_phone, order_ign, order_total, order_comment;
    String order_id_value = "";
    RecyclerView listProducts;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        order_id = findViewById(R.id.order_id_detail);
        order_phone = findViewById(R.id.order_phone_detail);
        order_ign = findViewById(R.id.order_ign_detail);
        order_total = findViewById(R.id.order_total_detail);
        order_comment = findViewById(R.id.order_comment_detail);

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
        order_ign.setText(Common.currentRequest.getAddress());
        order_comment.setText(Common.currentRequest.getComment());

        OrderDetailAdapter adapter = new OrderDetailAdapter(Common.currentRequest.getProducts());
        adapter.notifyDataSetChanged();
        listProducts.setAdapter(adapter);


    }
}

package com.example.barangkushopserver.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.barangkushopserver.Interface.ItemClickListener;
import com.example.barangkushopserver.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtOrderId, txtOrderStatus, txtOrderPhone, txtOrderIdGame, txtOrderDate, txtOrderCatatan, txtOrderContact;
    public Button btnEdit, btnRemove, btnDetail;


    private ItemClickListener itemClickListener;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txtOrderId = itemView.findViewById(R.id.order_id);
        txtOrderStatus = itemView.findViewById(R.id.order_status);
        txtOrderPhone = itemView.findViewById(R.id.order_phone);
        txtOrderIdGame = itemView.findViewById(R.id.order_idgame);
        txtOrderDate = itemView.findViewById(R.id.order_date);
        txtOrderCatatan = itemView.findViewById(R.id.order_catatan);
        txtOrderContact = itemView.findViewById(R.id.order_contact);

        btnDetail = itemView.findViewById(R.id.btnDetail);
        btnEdit = itemView.findViewById(R.id.btnEdit);
        btnRemove = itemView.findViewById(R.id.btnRemove);

      itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.OnClick(v, getAdapterPosition(), false);
    }

}

package com.example.barangkushopserver.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.barangkushopserver.Interface.ItemClickListener;
import com.example.barangkushopserver.R;

public class DatausersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView nohp_user, nama_user, password_user, secure_user;
    public Button delete_user;

    private ItemClickListener itemClickListener;

    public DatausersViewHolder(@NonNull View itemView) {
        super(itemView);

        nohp_user = itemView.findViewById(R.id.nohp_user);
        nama_user = itemView.findViewById(R.id.name_user);
        password_user = itemView.findViewById(R.id.password_user);
        secure_user = itemView.findViewById(R.id.secure_user);
        delete_user = itemView.findViewById(R.id.btndeleteuser);

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

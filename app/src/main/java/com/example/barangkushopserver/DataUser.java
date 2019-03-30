package com.example.barangkushopserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.barangkushopserver.Object.Request;
import com.example.barangkushopserver.Object.User;
import com.example.barangkushopserver.ViewHolder.DatausersViewHolder;
import com.example.barangkushopserver.ViewHolder.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataUser extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference datausers;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<User, DatausersViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_user);

        database = FirebaseDatabase.getInstance();
        datausers = database.getReference("User");

        recyclerView = findViewById(R.id.listUsers);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadUsers();
    }

    private void loadUsers() {
        adapter = new FirebaseRecyclerAdapter<User, DatausersViewHolder>(
                User.class,
                R.layout.data_user_layout,
                DatausersViewHolder.class,
                datausers
        ) {


            @Override
            protected void populateViewHolder(DatausersViewHolder viewHolder, User model, final int position) {
                viewHolder.nohp_user.setText(adapter.getRef(position).getKey());
                viewHolder.nama_user.setText(model.getName());
                viewHolder.password_user.setText(model.getPassword());
                viewHolder.secure_user.setText(model.getSecureCode());
                viewHolder.delete_user.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteOrder(adapter.getRef(position).getKey());
                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    private void deleteOrder(String key) {
        datausers.child(key).removeValue();
        adapter.notifyDataSetChanged();
    }


}

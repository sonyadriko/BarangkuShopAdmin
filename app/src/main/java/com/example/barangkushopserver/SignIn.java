package com.example.barangkushopserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.barangkushopserver.Common.Common;
import com.example.barangkushopserver.Object.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    EditText edtPhone, edtPassword;
    Button signIn;

    FirebaseDatabase database;
    DatabaseReference users;

    private static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword = findViewById(R.id.etPassword);
        edtPhone = findViewById(R.id.etNomorhp);
        signIn = findViewById(R.id.btnSignIn);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("User");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInUser(edtPhone.getText().toString(), edtPassword.getText().toString());
            }
        });
    }

    private void SignInUser(String  phone, String pass) {
        final String localphone = phone;
        final String localPssword = pass;
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(localphone).exists()) {
                    User user = dataSnapshot.child(localphone).getValue(User.class);
                    user.setPhone(localphone);
                    if (Boolean.parseBoolean(user.getIsStaff())) {
                        // Log.d(TAG, "OnCLickError");

                        if (user.getPassword().equals(localPssword)) {
                            Intent suclogin = new Intent(SignIn.this, Home.class);
                            Common.currentUser = user;
                            startActivity(suclogin);
                            //finish();

                        } else {
                            Toast.makeText(SignIn.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignIn.this, "Login with staff", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignIn.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

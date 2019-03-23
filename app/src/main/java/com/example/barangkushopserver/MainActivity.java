package com.example.barangkushopserver;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button signIn;
    TextView txtSlogan,nameapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = findViewById(R.id.buttonsignin);
        nameapp = findViewById(R.id.nameapps);
        txtSlogan = findViewById(R.id.txtslogan);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/hellovintage.ttf");
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/sweetlemon.ttf");
        txtSlogan.setTypeface(typeface);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignIn.class));
            }
        });
    }
}

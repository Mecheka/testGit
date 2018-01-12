package com.example.suriya.androideatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rilixtech.materialfancybutton.MaterialFancyButton;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvSlogan;
    private MaterialFancyButton btnSingUp;
    private MaterialFancyButton btnSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();
    }

    private void initInstance() {

        btnSingUp = (MaterialFancyButton) findViewById(R.id.btnSingUp);
        btnSingIn = (MaterialFancyButton) findViewById(R.id.btnSingIn);
        tvSlogan = (TextView)findViewById(R.id.tvSlogan);

        Typeface face = Typeface.createFromAsset(getAssets(), "NABILA.TTF");
        tvSlogan.setTypeface(face);

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singIntent = new Intent(MainActivity.this, SingInActivity.class);
                startActivity(singIntent);
            }
        });

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

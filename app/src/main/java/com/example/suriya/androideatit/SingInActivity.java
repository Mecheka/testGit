package com.example.suriya.androideatit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import info.hoang8f.widget.FButton;

public class SingInActivity extends AppCompatActivity {

    private MaterialEditText editPhone;
    private MaterialEditText editName;
    private MaterialEditText editPass;
    private MaterialFancyButton btnSingIn;
    private DatabaseReference mDataRefRoot;
    private DatabaseReference mDataRefUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        mDataRefRoot = FirebaseDatabase.getInstance().getReference();
        mDataRefUser = mDataRefRoot.child("User");

        intInstance();
    }

    private void intInstance() {

        editPhone = (MaterialEditText)findViewById(R.id.editPhone);
        editName = (MaterialEditText)findViewById(R.id.editName);
        editPass = (MaterialEditText)findViewById(R.id.editPass);
        btnSingIn = (MaterialFancyButton) findViewById(R.id.btnSingIn);

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataRefUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()){
                            User user = ds.child(editPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(editPass.getText().toString())){
                                Toast.makeText(SingInActivity.this, "Login", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(SingInActivity.this, "Faile", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}

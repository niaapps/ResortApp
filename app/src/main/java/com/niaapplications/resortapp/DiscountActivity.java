package com.niaapplications.resortapp;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;

import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.LinearLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

@TargetApi(28)
public class DiscountActivity extends AppCompatActivity {

    DatabaseReference ref;
    Discount discount;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        final LinearLayout container = (LinearLayout) findViewById(R.id.lLayout);
        discount = new Discount();
        ref = FirebaseDatabase.getInstance().getReference("businesses");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(150, 10, 150, 10);

                for (DataSnapshot discountSnapshot : dataSnapshot.getChildren()) {
                    discount = discountSnapshot.getValue(Discount.class);
                    int i = 0;
                    Button btn[] = new Button[100];

                    if(!discount.getName().toLowerCase().contains("resort") && !discount.getDescription().toLowerCase().contains("resort")) {
                        btn[i] = new Button(DiscountActivity.this);
                        btn[i].setText(discount.getDescription() + System.getProperty("line.separator") + discount.getName());
                        // btn[i].setBackground(discount.image);
                        btn[i].setBackgroundResource(R.drawable.roundcorners);
                        btn[i].setTextColor(getResources().getColor(R.color.colorPrimary));
                        btn[i].setPaddingRelative(15, 15, 15, 15);
                        btn[i].setWidth(700);
                        btn[i].setLayoutParams(params);
                        btn[i].setAllCaps(false);

                        container.addView(btn[i]);
                        i++;
                    }
                }
            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

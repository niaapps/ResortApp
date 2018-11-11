package com.niaapplications.resortapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  Button earn, msg, discount, reward;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    earn = (Button) findViewById(R.id.earnBtn);
    reward = (Button) findViewById(R.id.myRewardsBtn);
    discount = (Button) findViewById(R.id.discountsBtn);
    msg = (Button) findViewById(R.id.msgBtn);




    earn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent myIntent = new Intent(MainActivity.this, EarnActivity.class);
        MainActivity.this.startActivity(myIntent);
      }
    });
    reward.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent myIntent = new Intent(MainActivity.this, RewardActivity.class);
        MainActivity.this.startActivity(myIntent);
      }
    });
    discount.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent myIntent = new Intent(MainActivity.this, DiscountActivity.class);
        MainActivity.this.startActivity(myIntent);
      }
    });
    msg.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent myIntent = new Intent(MainActivity.this, MessageActivity.class);
        MainActivity.this.startActivity(myIntent);
      }
    });




  }

}

package com.niaapplications.resortapp;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RewardActivity extends AppCompatActivity {

  ListView listViewRewards;
  Rewards rewards;
  List<Rewards> rewardsList;
  @Override
  protected void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reward);

    listViewRewards = (ListView) findViewById(R.id.listRLayout);
    rewards = new Rewards();
    rewardsList = new ArrayList<>();
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("rewards");


    //attaching value event listener
    ref.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        //clearing the previous artist list
        rewardsList.clear();

        //iterating through all the nodes
        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
          //getting reward
          Rewards rewardObj = postSnapshot.getValue(Rewards.class);
          //adding reward to the list
          rewardsList.add(rewardObj);
        }

        //creating adapter
        RewardList rewardAdapter = new RewardList(RewardActivity.this, rewardsList);
        //attaching adapter to the listview
        listViewRewards.setAdapter(rewardAdapter);
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }
    });


  }


}

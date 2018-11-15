package com.niaapplications.resortapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageActivity extends AppCompatActivity {

    ImageButton send;
    EditText typedMessage;
    String  from;
    LinearLayoutManager layoutManager;
    RecyclerView rView;
    Conversations convo;
    DatabaseReference ref;
    boolean result = true;
    SwipeRefreshLayout swipeRefreshLayout;



    private final List<Conversations> messagesList = new ArrayList<>();
    private MessageAdapter adapter;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.message_swipe_layout);
        convo = new Conversations();
        send = (ImageButton) findViewById(R.id.chat_send_btn);
        typedMessage = (EditText) findViewById(R.id.chat_message_view);
        rView = (RecyclerView) findViewById(R.id.messages_list);

        layoutManager = new LinearLayoutManager(this);
        adapter = new MessageAdapter(messagesList);
        convo.setFromID(from=finalId());
        layoutManager.setReverseLayout(true);
        rView.setLayoutManager(layoutManager);
        rView.setHasFixedSize(true);
        rView.setItemAnimator(new DefaultItemAnimator());
        rView.setAdapter(adapter);



        loadMessages();
        ref = FirebaseDatabase.getInstance().getReference("conversations").child("-LPNCOSB-guOYWCHOFyA");


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newConversation();

              sendMessage();
            }
        });
    }

    private void newConversation(){
            String to,type;
            boolean initRead = false;
            to = "bfNsg3w507WaKUNDYra35RmEf2j2";
            type = "text";
            from = finalId();
            long time;
            String msg = typedMessage.getText().toString();
            time = System.currentTimeMillis()/1000;
            if(!TextUtils.isEmpty(msg)){

                String id =ref.push().getKey();

                Conversations convo = new Conversations(msg,from,initRead,time, to ,type);

                ref.child(id).setValue(convo);


            }else{
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_LONG);
            }

    }


    private void loadMessages(){

            DatabaseReference refContent = FirebaseDatabase.getInstance().getReference("conversations").child("-LPNCOSB-guOYWCHOFyA").child("content");

        if((refContent.child("fromID").toString().equals("bfNsg3w507WaKUNDYra35RmEf2j2"))&& (refContent.child("toID").toString().equals(convo.getFromID()))){

            refContent.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange (@NonNull DataSnapshot dataSnapshot){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        Conversations conversations = snapshot.getValue(Conversations.class);
                        messagesList.add(conversations);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });  }
        }

    private void sendMessage() {

        String message = typedMessage.getText().toString();

        if(!TextUtils.isEmpty(message)){

            typedMessage.setText("");
        }
        convo.setIsRead(true);
        convo.setTimestamp(System.currentTimeMillis()/1000);
    }

    public  String finalId() {
        String m = makeIdString();
        if (validId(m) == true) {
            return m;
        } else {
           finalId();
            return m;
        }
    }


    protected String makeIdString() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwzyz1234567890";
        StringBuilder id = new StringBuilder();
        Random rnd = new Random();
        while (id.length() < 29) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            id.append(CHARS.charAt(index));
        }
        String str = id.toString();
        return str;

    }
    protected  boolean validId( String id){
        final String tempId = id;
        DatabaseReference refCheck;
        refCheck = FirebaseDatabase.getInstance().getReference().child("conversations").child("fromId");
        refCheck.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for ( DataSnapshot fromIdSnap : dataSnapshot.getChildren()) {
                    if(fromIdSnap.toString() == tempId) {

                        result = false;
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return result;

    }



}

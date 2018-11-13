package com.niaapplications.resortapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    ImageButton send;
    EditText typedMessage;
    LinearLayoutManager layoutManager;
    RecyclerView rView;
    Conversations convo;
    DatabaseReference ref;
    SwipeRefreshLayout swipeRefreshLayout;

    private final List<Conversations> messagesList = new ArrayList<>();
    private MessageAdapter adapter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

       swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.message_swipe_layout);
        Conversations convo = new Conversations();
        send = (ImageButton) findViewById(R.id.chat_send_btn);
        typedMessage = (EditText) findViewById(R.id.chat_message_view);
        rView = (RecyclerView) findViewById(R.id.messages_list);
        layoutManager = new LinearLayoutManager(this);
        adapter = new MessageAdapter(messagesList);

        layoutManager.setReverseLayout(true);
        rView.setLayoutManager(layoutManager);
        rView.setHasFixedSize(true);

        rView.setAdapter(adapter);

        convo.getFromId();
        convo.setContent(typedMessage.toString());

        ref = FirebaseDatabase.getInstance().getReference("conversations");


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }
    private void sendMessage() {


        String message = typedMessage.getText().toString();

        if(!TextUtils.isEmpty(message)){

            typedMessage.setText("");

           ref.child("isRead").setValue(true);
           ref.child("timestamp").setValue(ServerValue.TIMESTAMP);


        }

    }



}

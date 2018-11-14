package com.niaapplications.resortapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{


    private List<Conversations> messageList;
    private DatabaseReference ref;
    Conversations conversation = new Conversations();




    public MessageAdapter(List<Conversations> messageList) {

        this.messageList = messageList;

    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.messages_layout ,parent, false);
            return new MessageViewHolder(v);


    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView messageText;
        public TextView timeStamp;

        public MessageViewHolder(View view) {
            super(view);

            messageText = (TextView) view.findViewById(R.id.text_message);
            timeStamp = (TextView) view.findViewById(R.id.text_message_time);

            onBindViewHolder(MessageViewHolder.this,10);


        }
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder viewHolder, int i) {
        ref = FirebaseDatabase.getInstance().getReference("conversations").child("-LPNCOSB-guOYWCHOFyA").child("fromId");
        conversation = messageList.get(i);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                    String from = conversation.getFromId();

                    if(from.equals(snapshot)){
                        viewHolder.messageText.setText(conversation.getContent());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference refReplies = FirebaseDatabase.getInstance().getReference("conversations").child("-LPNCOSB-guOYWCHOFyA").child("toId");
            refReplies.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                        String from = conversation.getFromId();

                        if(from.equals(snapshot)){
                            viewHolder.messageText.setBackgroundResource(R.drawable.msgboxr);
                            viewHolder.messageText.setText(conversation.getContent());
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
    }




    @Override
    public int getItemCount() {
        return messageList.size();
    }






}
package com.niaapplications.resortapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
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

        String fromUser = conversation.getFromId();
        String toUser = conversation.getToId();
        if(fromUser == "bfNsg3w507WaKUNDYra35RmEf2j2" && toUser == conversation.getId() ){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.msg_received ,parent, false);
            return new MessageViewHolder(v);
        }else{
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.msg_sent ,parent, false);
            return new MessageViewHolder(v);
        }

    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView messageText;

        public MessageViewHolder(View view) {
            super(view);

            messageText = (TextView) view.findViewById(R.id.text_message_body);

        }
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder viewHolder, int i) {

        conversation = messageList.get(i);


        ref = FirebaseDatabase.getInstance().getReference().child("Conversations").child("fromId");

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }






}
package com.niaapplications.resortapp;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import java.lang.String;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{

    Conversations conversation = new Conversations();

    private List<Conversations> messageList;
    private DatabaseReference ref;


    public MessageAdapter(List<Conversations> messageList) {

        this.messageList = messageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(conversation.getToID() == "bfNsg3w507WaKUNDYra35RmEf2j2"){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.msg_send ,parent, false);
            return new MessageViewHolder(v);

        }else{
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.msg_receive ,parent, false);
            return new MessageViewHolder(v);
        }



    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView messageText;
        public TextView timeStamp;

        public MessageViewHolder(View view) {
            super(view);

            messageText = (TextView) view.findViewById(R.id.text_message);
            timeStamp = (TextView) view.findViewById(R.id.text_message_time);


        }
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder viewHolder, int i) {
        final  String a = Long.toString(conversation.getTimestamp());

        viewHolder.messageText.setText(messageList.get(i).getContent());
        viewHolder.timeStamp.setText(a);
    }




    @Override
    public int getItemCount() {
        return messageList.size();
    }






}
package com.niaapplications.resortapp;

public class Conversations {
    private  String content;
    private  String fromId;
    private  boolean isRead = false;
    private  int timestamp;
    private  String toId = "bfNsg3w507WaKUNDYra35RmEf2j2";
    private  String type = "text";


public Conversations(){
    this.content = content;
    this.fromId = fromId;
    this.isRead = isRead;
    this.timestamp = timestamp;
    this.toId = toId;
    this.type = type;
}


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

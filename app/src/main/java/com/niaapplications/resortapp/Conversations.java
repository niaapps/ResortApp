package com.niaapplications.resortapp;


import com.google.firebase.database.DatabaseReference;


public class Conversations {
    private  String content;
    private  String fromID;
    private  boolean isRead = false;
    private  long timestamp;
    private  String toID = "bfNsg3w507WaKUNDYra35RmEf2j2";
    private  String type = "text";
    DatabaseReference reference;


public Conversations(){

}

    public Conversations(String content, String fromID, boolean isRead, long timestamp, String toID, String type){
    this.content = content;
    this.fromID = fromID;
    this.isRead = isRead;
    this.timestamp = timestamp;
    this.toID = toID;
    this.type = type;
}


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromID() {
        return  fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        isRead = isRead;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

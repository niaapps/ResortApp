package com.niaapplications.resortapp;


import com.google.firebase.database.DatabaseReference;


public class Conversations {
    private  String content;
    private  String fromId;
    private  boolean isRead = false;
    private  long timestamp;
    private  String id;
    private  String toId = "bfNsg3w507WaKUNDYra35RmEf2j2";
    private  String type = "text";
    DatabaseReference reference;


public Conversations(){

}

    public Conversations(String content, String fromId, boolean isRead, long timestamp, String toId, String type){
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
        return  fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
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

    public String getId() {
        return fromId;
    }

    public void setId(String id) {
        this.id = fromId;
    }


}

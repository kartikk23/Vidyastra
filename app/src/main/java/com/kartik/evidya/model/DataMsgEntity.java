package com.kartik.evidya.model;

import com.google.gson.annotations.SerializedName;

public class DataMsgEntity {
    @SerializedName("chat_id")
    private int chat_id;

    @SerializedName("message_from")
    private int message_from;

    @SerializedName("message_to")
    private int message_to;

    @SerializedName("chat")
    private String chat;

    @SerializedName("created_at")
    private String created_at;

    public DataMsgEntity(int chat_id, int message_from, int message_to, String chat, String created_at) {
        this.chat_id = chat_id;
        this.message_from = message_from;
        this.message_to = message_to;
        this.chat = chat;
        this.created_at = created_at;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getMessage_from() {
        return message_from;
    }

    public void setMessage_from(int message_from) {
        this.message_from = message_from;
    }

    public int getMessage_to() {
        return message_to;
    }

    public void setMessage_to(int message_to) {
        this.message_to = message_to;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

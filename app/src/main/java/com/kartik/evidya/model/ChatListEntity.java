package com.kartik.evidya.model;

import com.google.gson.annotations.SerializedName;

public class ChatListEntity {
    @SerializedName("message")
    private String message;

    @SerializedName("dataMsgEntity")
    private DataMsgEntity dataMsgEntity;

    private boolean isSeen;

    public ChatListEntity(String message, DataMsgEntity dataMsgEntity, boolean isSeen) {
        this.message = message;
        this.dataMsgEntity = dataMsgEntity;
        this.isSeen = isSeen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataMsgEntity getDataMsgEntity() {
        return dataMsgEntity;
    }

    public void setDataMsgEntity(DataMsgEntity dataMsgEntity) {
        this.dataMsgEntity = dataMsgEntity;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }
}

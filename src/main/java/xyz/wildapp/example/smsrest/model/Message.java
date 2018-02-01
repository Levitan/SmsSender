
package xyz.wildapp.example.smsrest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("smsCount")
    @Expose
    private Integer smsCount;
    @SerializedName("messageId")
    @Expose
    private String messageId;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

}

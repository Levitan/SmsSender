
package xyz.wildapp.example.smsrest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SmsResponse {

    @SerializedName("messages")
    @Expose
    private List<Message> messages = null;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}

package xyz.wildapp.example.smsrest.repo;

import org.springframework.stereotype.Controller;
import retrofit2.Response;
import xyz.wildapp.example.smsrest.model.Message;
import xyz.wildapp.example.smsrest.model.SmsResponse;
import xyz.wildapp.example.smsrest.model.Status;

import java.util.Collections;

@Controller
public class CallBackRepository {
    public SmsResponse createCallBack(Response<SmsResponse> response){
        SmsResponse callback = new SmsResponse();
        Status callbackStatus = new Status();
        callbackStatus.setName("Error while message sending error code: " + String.valueOf(response.code()));
        callbackStatus.setDescription("Response body: " + response.body());
        Message callbackMessage = new Message();
        callbackMessage.setStatus(callbackStatus);
        callback.setMessages(Collections.singletonList(callbackMessage));
        return callback;
    }
}

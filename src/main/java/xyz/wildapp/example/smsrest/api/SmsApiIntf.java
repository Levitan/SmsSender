package xyz.wildapp.example.smsrest.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import xyz.wildapp.example.smsrest.model.SmsRequest;
import xyz.wildapp.example.smsrest.model.SmsResponse;

public interface SmsApiIntf {

    @POST(value = "/sms/1/text/single")
    Call<SmsResponse> sendMessage(@Body SmsRequest request);
}

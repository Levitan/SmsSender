package xyz.wildapp.example.smsrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import xyz.wildapp.example.smsrest.api.SmsApiIntf;
import xyz.wildapp.example.smsrest.model.SmsRequest;
import xyz.wildapp.example.smsrest.model.SmsResponse;

import java.io.IOException;

@RestController
public class RESTController {

    private final Logger logger = LoggerFactory.getLogger(RESTController.class);

    @Autowired
    private SmsApiIntf api;

    @RequestMapping("/sendsms")
    public SmsResponse getData() throws IOException {
        SmsRequest request = new SmsRequest();
        request.setFrom("Wildapp Software");
        request.setTo("79372573782");
        request.setText("Hello from wildapp");
        Call<SmsResponse> call = api.sendMessage(request);
        Response<SmsResponse> resp = call.execute();
        logger.info("Response code: {}", resp.code());
        SmsResponse response = resp.body();
        return response;
    }
}

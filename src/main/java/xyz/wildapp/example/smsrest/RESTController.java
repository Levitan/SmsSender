package xyz.wildapp.example.smsrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;
import xyz.wildapp.example.smsrest.api.SmsApiIntf;
import xyz.wildapp.example.smsrest.model.SmsRequest;
import xyz.wildapp.example.smsrest.model.SmsResponse;
import xyz.wildapp.example.smsrest.repo.CallBackRepository;

import java.io.IOException;

@RestController
public class RESTController {

    private final Logger logger = LoggerFactory.getLogger(RESTController.class);

    @Autowired
    private SmsApiIntf api;

    @Autowired
    private CallBackRepository callback;

    @RequestMapping("/sendsms")
    public SmsResponse getData() throws IOException {
        SmsRequest request = new SmsRequest("Wildapp Software",
                "79372573782", "Hello from wildapp");

        Response<SmsResponse> resp = api.sendMessage(request).execute();
        if(resp.code() != 200){
            logger.info("Response code: {}", resp.code());
            return callback.createCallBack(resp);
        }
        return resp.body();
    }
}

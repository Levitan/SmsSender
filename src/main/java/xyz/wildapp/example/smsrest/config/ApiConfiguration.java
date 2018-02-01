package xyz.wildapp.example.smsrest.config;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.wildapp.example.smsrest.api.SmsApiIntf;

@Configuration
public class ApiConfiguration {

    @Value("${sms.service.url}")
    private String smsServiceUrl;

    @Value("${sms.username}")
    private String username;

    @Value("${sms.password}")
    private String password;

    @Bean
    public SmsApiIntf smsApiIntf(){
        String authToken = Credentials.basic(username, password);
        AuthInterceptor interceptor = new AuthInterceptor(authToken);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(interceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(smsServiceUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(SmsApiIntf.class);
    }

}

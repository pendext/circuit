package com.pendext.circuit.service;

import com.pendext.circuit.service.transfer.LocalDateTimeJson;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LocalDateRetriever {

    @Value("${local.date.endpoint}")
    String localDateEndpoint;

    public LocalDateTimeJson getLocalDate() {
        LocalDateTimeJson localDateTimeJson = null;
        Request request = new Request.Builder()
                .url(localDateEndpoint)
                .build();
        try {
            Response response = new OkHttpClient().newCall(request).execute();
            localDateTimeJson = new LocalDateTimeJson(IOUtils.toString(response.body().byteStream(), "UTF-8"));
        } catch (IOException e) {
        }
        return localDateTimeJson;
    }

}

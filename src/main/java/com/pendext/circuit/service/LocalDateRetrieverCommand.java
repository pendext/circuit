package com.pendext.circuit.service;

import com.netflix.hystrix.*;
import com.pendext.circuit.service.transfer.LocalDateTimeJson;
import okhttp3.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;


public class LocalDateRetrieverCommand extends HystrixCommand<LocalDateTimeJson> {

    private String localDateEndpoint;

    public LocalDateRetrieverCommand(String localDateEndpoint) {
        super(HystrixCommandGroupKey.Factory.asKey("LocalDateRetriever"));
        this.localDateEndpoint = localDateEndpoint;
    }

    @Override
    protected LocalDateTimeJson run() {
        LocalDateTimeJson localDateTimeJson = null;
        Request request = new Request.Builder()
                .url(localDateEndpoint)
                .build();
        try {
            Response response = new OkHttpClient().newCall(request).execute();
            localDateTimeJson = new LocalDateTimeJson(IOUtils.toString(response.body().byteStream(), "UTF-8"));
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localDateTimeJson;
    }

    @Override
    protected LocalDateTimeJson getFallback() {
        return new LocalDateTimeJson("{\"hour\":00,\"minute\":00,\"second\":00,\"nano\":615000000,\"monthValue\":0,\"dayOfMonth\":0,\"dayOfWeek\":\"TUESDAY\",\"dayOfYear\":0,\"year\":2001,\"month\":\"JANUARY\",\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}");
    }

}

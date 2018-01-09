package com.pendext.circuit.controller;

import com.pendext.circuit.service.LocalDateRetrieverCommand;
import com.pendext.circuit.service.transfer.LocalDateTimeJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class LocalDateController {

    @Value("${local.date.endpoint}")
    String localDateEndpoint;

    @RequestMapping(path = "/date", method = RequestMethod.GET)
    public LocalDateTimeJson getLocalDate() throws ExecutionException, InterruptedException {
        return new LocalDateRetrieverCommand(localDateEndpoint).queue().get();
    }

}

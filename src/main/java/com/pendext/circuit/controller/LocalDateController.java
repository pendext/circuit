package com.pendext.circuit.controller;

import com.pendext.circuit.service.LocalDateRetriever;
import com.pendext.circuit.service.transfer.LocalDateTimeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocalDateController {

    @Autowired
    LocalDateRetriever localDateRetriever;

    @RequestMapping(path = "/date", method = RequestMethod.GET)
    public LocalDateTimeJson getLocalDate() {
        return localDateRetriever.getLocalDate();
    }

}

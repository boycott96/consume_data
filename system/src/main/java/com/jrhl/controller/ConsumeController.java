package com.jrhl.controller;

import com.jrhl.api.ConsumeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumeController {

    private final ConsumeApi consumeApi;

    @Autowired
    public ConsumeController(ConsumeApi consumeApi) {
        this.consumeApi = consumeApi;
    }

    @GetMapping(value = "/data")
    public String getConsumeData() {
        consumeApi.getRemoteConsumeData();
        return "成功";
    }
}

package com.example.cloud.publisherrabbit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@EnableBinding(Source.class)
@RestController
public class BriefController {

    @Autowired
    Source source;

    @RequestMapping(path="/brief", method = RequestMethod.POST)
    public String publishMessage(@RequestBody String payLoad) {
        System.out.println();
        source.output().send(MessageBuilder.withPayload(payLoad).build());
        return "Success";
    }

}

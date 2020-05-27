package io.bisht.consumerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

import io.bisht.consumerservice.model.User;

@Controller
public class ConsumerController {

	 private KafkaTemplate<String, String> kafkaTemplate;
	    private Gson jsonConverter;
	   
	    @Autowired
	    ConsumerController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter){
		 this.kafkaTemplate = kafkaTemplate;
	     this.jsonConverter = jsonConverter;
	}
	
	@KafkaListener(topics = "mytopic")
    public void getFromKafka2(String moreSimpleModel){
        System.out.println(moreSimpleModel);

        User simpleModel1 = (User) jsonConverter.fromJson(moreSimpleModel, User.class);

        System.out.println(simpleModel1.toString());
    }
}

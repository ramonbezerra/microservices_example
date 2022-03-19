package br.edu.uepb.example.firstmicroservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping
    public String getMessage() {
        try {
            String json = new ObjectMapper().writeValueAsString("Hello World");
            rabbitTemplate.convertAndSend(HelloAMQPConfig.EXCHANGE_NAME, "", json);
        } catch (JsonProcessingException  e) {
            e.printStackTrace();
        }
        return "Hello World";
    }
    
}

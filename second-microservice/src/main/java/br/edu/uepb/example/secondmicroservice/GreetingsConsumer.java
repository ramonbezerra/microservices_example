package br.edu.uepb.example.secondmicroservice;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GreetingsConsumer {
    
    @RabbitListener(queues = HiAMQPConfig.QUEUE)
    public void consumer(Message message) {
        
    }
}

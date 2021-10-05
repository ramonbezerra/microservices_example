package br.edu.uepb.example.secondmicroservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {
    
    @GetMapping
    public String getMessage() {
        return "Hi!";
    }
}

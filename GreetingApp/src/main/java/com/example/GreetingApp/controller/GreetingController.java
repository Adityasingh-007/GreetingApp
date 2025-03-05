package com.example.GreetingApp.controller;

import com.example.GreetingApp.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @GetMapping
    public Greeting getGreetings(){
        return new Greeting("Hello , My name is Aditya singh !");
    }
    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting newGreeting){
        return new Greeting("Greeting Created :"+newGreeting.getMessage());
    }
    @PutMapping
    public Greeting updateGreeting(@RequestBody Greeting updatedGreeting){
        return new Greeting("Greetings Updated :"+updatedGreeting.getMessage());
    }
    @DeleteMapping
    public Greeting deleteGreeting(){
        return new Greeting("Greeting Deleted ");
    }
}

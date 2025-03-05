package com.example.GreetingApp.controller;

import com.example.GreetingApp.model.Greeting;
import com.example.GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class GreetingController {

    @RequestMapping("/")
    public String sayHello(){
        return "Hello from bridgeLab";
    }

    @GetMapping("/greetings")
    public Greeting getGreetings(){
        return new Greeting("Hello , My name is Aditya singh !");
    }

    @PostMapping("/greetings")
    public Greeting createGreeting(@RequestBody Greeting newGreeting){
        return new Greeting("Greeting Created :"+newGreeting.getMessage());
    }

    @PutMapping("/greetings")
    public Greeting updateGreeting(@RequestBody Greeting updatedGreeting){
        return new Greeting("Greetings Updated :"+updatedGreeting.getMessage());
    }

    @DeleteMapping("/greetings")
    public Greeting deleteGreeting(){
        return new Greeting("Greeting Deleted ");
    }

//    UC2
    @Autowired
    GreetingService greetingService;


//    UC3

    @GetMapping("greetings/user")
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String message;

        if(firstName != null && lastName != null){
            message = "Hello, " + firstName + " " + lastName ;
        }
        else if(firstName != null){
            message = "Hello" + firstName;
        }
        else if(lastName != null){
            message = "Hello" + lastName ;
        }
        else{
            message = "Hello, World";
        }
        return new Greeting(message);
    }


}

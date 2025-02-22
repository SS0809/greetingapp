package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.service.GreetingService;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
//the { payload -> GreetingDTO } is passed by value to service section for backend logic
    @Autowired
    GreetingService greetingService;

    @GetMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<ObjectNode> sayHello(@RequestParam Long id) {
        return ResponseEntity.ok(greetingService.getmyservice(id));
    }
    //Get All
    @GetMapping(value = "/helloAll",produces = "application/json")
    public ResponseEntity<ArrayNode> helloAll(){
        return ResponseEntity.ok(greetingService.getAllservice());
    }
    //Post Mapping
    @PostMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<ObjectNode> postHello(@RequestBody GreetingDTO newData) {
        return ResponseEntity.ok(greetingService.setmyservice(newData));
    }
    //Put Mapping
    @PutMapping(value = "/hello",produces = "application/json")
    public ResponseEntity<ObjectNode> putHello(@RequestBody GreetingDTO newData) {
        return ResponseEntity.ok(greetingService.setmyservice(newData));
    }
    //Delete Mapping
    @DeleteMapping(value = "/hello",produces = "application/json")
    public ResponseEntity<String> deleteHello(@RequestBody GreetingDTO newData){
        return ResponseEntity.ok(greetingService.deletemyservice(newData));
    }
}
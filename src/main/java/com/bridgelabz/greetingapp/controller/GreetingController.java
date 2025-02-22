package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.service.GreetingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.coyote.Response;
import org.apache.juli.logging.Log;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class GreetingController {
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectNode objectNode;
    GreetingController(){
        objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "default_value");
    }
    @Autowired
    GreetingService greetingService;
    @GetMapping(value = {"/hello", "/hello/{Fname}", "/hello/{Fname}/{Lname}"}, produces = "application/json")
    public ResponseEntity<ObjectNode> sayHello(
            @PathVariable(value = "Fname", required = false) Optional<String> Fname,
            @PathVariable(value = "Lname", required = false) Optional<String> Lname) {
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        Fname.ifPresent(value -> objectNode.put("Fname", value));
        Lname.ifPresent(value -> objectNode.put("Lname", value));
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }
    //Get All
    @GetMapping(value = "/helloAll",produces = "application/json")
    public ResponseEntity<ObjectNode> helloAll(){
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }
    //Post Mapping
    @PostMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<ObjectNode> postHello(@RequestBody Map<String, String> newData) {
        objectNode.put("name", newData.get("name"));
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }
    //Put Mapping
    @PutMapping(value = "/hello",produces = "application/json")
    public ResponseEntity<ObjectNode> putHello(@RequestBody Map<String,String> newData){
        objectNode.put("name", newData.get("name"));
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }
    //Delete Mapping
    @DeleteMapping(value = "/hello",produces = "application/json")
    public ResponseEntity<ObjectNode> deleteHello(@RequestBody Map<String,String> newData){
        objectNode.remove("name");
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }
}
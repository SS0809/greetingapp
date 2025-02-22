package com.bridgelabz.greetingapp.controller;

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
    //Get Mapping
    @GetMapping(value = "/hello",produces = "application/json")
    public ResponseEntity<ObjectNode> sayHello(){
        return ResponseEntity.ok(objectNode);
    }
    //Get All
    @GetMapping(value = "/helloAll",produces = "application/json")
    public ResponseEntity<ObjectNode> helloAll(){
        return ResponseEntity.ok(objectNode);
    }
    //Post Mapping
    @PostMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<ObjectNode> postHello(@RequestBody Map<String, String> newData) {
        objectNode.put("name", newData.get("name"));
        return ResponseEntity.ok(objectNode);
    }
    //Put Mapping
    @PutMapping(value = "/hello",produces = "application/json")
    public ResponseEntity<ObjectNode> putHello(@RequestBody Map<String,String> newData){
        objectNode.put("name", newData.get("name"));
        return ResponseEntity.ok(objectNode);
    }
    //Delete Mapping
    @DeleteMapping(value = "/hello",produces = "application/json")
    public ResponseEntity<ObjectNode> deleteHello(@RequestBody Map<String,String> newData){
        return ResponseEntity.ok(new ObjectMapper().createObjectNode().put("name",newData.remove("name")));
    }
}
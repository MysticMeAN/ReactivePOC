package com.reactiveRedis.User.Controller;

import com.reactiveRedis.User.Model.userEntity;
import com.reactiveRedis.User.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.Map;

@RestController
@RequestMapping("/user")
public class MyController {

    @Autowired
    private userService userServiceObj;

    @PostMapping("/send")
    public Mono<userEntity> createUser(@RequestBody Map<String, String> user){

        WebClient webClient = WebClient.create("http://localhost:8082");


        return webClient.post()
                .uri("/user/send")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(user), userEntity.class)
                .retrieve()
                .bodyToMono(userEntity.class);

         // return userServiceObj.saveUser(user);
    }

    @GetMapping("/{userId}")
    public Mono<userEntity> getUserById(@PathVariable String userId){

        WebClient webClient = WebClient.create("http://localhost:8082");


            return webClient.get()
                    .uri("/user/{id}", userId)
                    .retrieve()
                    .bodyToMono(userEntity.class);

            // return userServiceObj.getUserById(userId);
        }



}

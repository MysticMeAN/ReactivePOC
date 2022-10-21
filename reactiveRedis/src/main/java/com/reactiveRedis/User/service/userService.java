package com.reactiveRedis.User.service;

import com.reactiveRedis.User.Model.userEntity;
import com.reactiveRedis.User.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Service
public class userService {

    @Autowired
    private userRepository userRepo;

    public Mono<userEntity> saveUser(Map<String, String> body){
       userEntity user = new userEntity();
       user.setName(body.get("name"));
//     String userId = UUID.randomUUID().toString().replaceAll("-", "");
       user.setId(body.get("id"));

       return userRepo.save(user);
    }

    public Mono<userEntity> getUserById(String id)
    {
        return userRepo.findById(id);
    }
}

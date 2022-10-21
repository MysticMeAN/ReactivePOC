package com.reactiveRedis.User.Repository;

import com.reactiveRedis.User.Model.userEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface userRepository extends ReactiveCrudRepository<userEntity, String> {

}

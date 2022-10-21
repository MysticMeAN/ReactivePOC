package com.reactiveRedis.User.Repository;

import com.reactiveRedis.User.Model.userEntity;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class userRepositoryImp implements userRepository {

    private final static String KEY = "USERS";

    private final ReactiveRedisOperations<String, userEntity> redisOperations;
    private final ReactiveHashOperations<String, String, userEntity> hashOperations;

    @Autowired
    public userRepositoryImp(ReactiveRedisOperations<String, userEntity> redisOperations) {
        this.redisOperations = redisOperations;
        this.hashOperations = redisOperations.opsForHash();
    }

    @Override
    public Mono<userEntity> findById(String id) {
        System.out.println(Thread.currentThread().getName());
        return hashOperations.get(KEY, id).log();
    }

    @Override
    public Mono<userEntity> save(userEntity user) {
        return hashOperations.put(KEY, user.getId(), user)
                .map(isSaved -> user).thenReturn(user);

    }

    @Override
    public <S extends userEntity> Flux<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends userEntity> Flux<S> saveAll(Publisher<S> entityStream) {
        return null;
    }



    @Override
    public Mono<userEntity> findById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> id) {
        return null;
    }

    @Override
    public Flux<userEntity> findAll() {
        return null;
    }

    @Override
    public Flux<userEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public Flux<userEntity> findAllById(Publisher<String> idStream) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Void> delete(userEntity entity) {
        return null;
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<? extends String> strings) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends userEntity> entities) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends userEntity> entityStream) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }


}

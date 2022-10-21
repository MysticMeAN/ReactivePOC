package com.reactiveRedis.User.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class userEntity implements Serializable {
    @Id
    private String id;

    private String Name;
}

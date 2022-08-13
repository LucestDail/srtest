package com.hello;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HelloService {

    public String getHello() {
        return "Hello test 222 333 " + LocalDateTime.now();
    }

}
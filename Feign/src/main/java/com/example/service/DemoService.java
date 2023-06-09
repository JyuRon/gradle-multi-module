package com.example.service;

import com.example.feign.client.DemoFeignClient;
import com.example.feign.common.dto.BaseRequestInfo;
import com.example.feign.common.dto.BaseResponseInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final DemoFeignClient demoFeignClient;

    public String get(){

        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 22L);

        System.out.println("Name : " + response.getBody().getName());
        System.out.println("Age : " + response.getBody().getAge());
        System.out.println("Header : " + response.getBody().getHeader());
        return "get";
    }

    public String post() {

        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callPost(
                "CustomHeader", BaseRequestInfo.builder()
                        .name("customName")
                        .age(22L)
                        .build()
        );

        System.out.println("Name : " + response.getBody().getName());
        System.out.println("Age : " + response.getBody().getAge());
        System.out.println("Header : " + response.getBody().getHeader());
        return "post";
    }

    public String errorDecoder() {
        demoFeignClient.callErrorDecoder();
        return "error";
    }
}

package org.mjulikelion.likelion12thspringboot.service;


import org.springframework.stereotype.Service;

@Service    //@Component를 내장하고 있음
public class HelloService {
    public String hello(){
        return "Hello, likelion!!!";
    }
}

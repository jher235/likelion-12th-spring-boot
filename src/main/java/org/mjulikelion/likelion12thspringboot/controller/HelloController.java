package org.mjulikelion.likelion12thspringboot.controller;



import org.mjulikelion.likelion12thspringboot.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller   //MVC Controller
@RestController //안에 @Controller를 내장하고 있고 @Controller는 @Component를 내장하고 있어서 Bean으로 등록되는 것.
public class HelloController {

    private final HelloService helloService;

//    생성자 주입 방법
    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(){
        return helloService.hello();
    }

}

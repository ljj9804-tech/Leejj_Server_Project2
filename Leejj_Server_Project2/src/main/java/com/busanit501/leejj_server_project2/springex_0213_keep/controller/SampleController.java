package com.busanit501.leejj_server_project2.springex_0213_keep.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello2")
    public void hello() {
        log.info("hello spring mvc ~~~");
    }

    //http://localhost:8080/ex1?name=이진주&age=20
    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1 ~~~");
        log.info("데이터 수집 : name : " + name);
        log.info("데이터 수집 : age : " + age);
    }

    //http://localhost:8080/ex2
    //http://localhost:8080/ex2?name=&age=
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "이름을 입력하세요") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age) {
        log.info("ex2 ~~~");
        log.info("데이터 수집 : name : " + name);
        log.info("데이터 수집 : age : " + age);
    }

    //http://localhost:8080/ex3?dueDate=2026-02-13
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3 ~~~");
        log.info("데이터 수집 : dueDate : " + dueDate);
    }

    //http://localhost:8080/ex4
    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("ex4 ~~~");
        log.info("데이터 받아서 화면에 전달");
        //model 이용하기
        model.addAttribute("msg","hello~~!!");
    }

}


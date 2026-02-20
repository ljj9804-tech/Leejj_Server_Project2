package com.busanit501.leejj_server_project2.springex_new_0219_keep.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //http://localhost:8080/ex5
    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        log.info("ex5");
        log.info("데이터 받아서 화면에 전달 쿼리스트링으로 전달, 1회용으로");
        redirectAttributes.addAttribute("name","TEST EX5");
        //1회용으로
        redirectAttributes.addFlashAttribute("result","SUCCESS");
        return "redirect:/ex6";

    }
    @GetMapping("/ex6")
    public void ex6() {

    }

    @GetMapping("/ex7")
    // 예외 포인트는 화면에서 전달하는 값은 기본 무조건 문자열임.
    // 그런데, 받을 때, 임의로 숫자 타입으로 받고 있음.
    // 예외가 발생되는 부분.
    public void ex7(String p1, int p2) {
        log.info("p1 : " + p1);
        log.info("p2 : " + p2);
    }

}


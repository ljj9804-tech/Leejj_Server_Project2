package com.busanit501.leejj_server_project2._0209_todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name="_0209_16_LogoutController", urlPatterns = "/logout_0209")
public class _0209_16_LogoutController extends HttpServlet {
    // 로그 아웃 처리.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("로그아웃 처리를 담당하느 doPost 입니다. ");

        // 임시 로그아웃 효과,
        HttpSession session = req.getSession();
        // 세션의 loginInfo 라는 키를 삭제하면 됩니다.
        session.removeAttribute("loginInfo");
        // 적용하기.
        session.invalidate();

        // 2. 쿠키 삭제 로직 추가
        Cookie viewCookie = findCookie(req.getCookies(), "remember-me"); // 쿠키 찾기

        if (viewCookie != null) {
            viewCookie.setPath("/");       // 쿠키 생성 시 설정했던 경로와 일치해야 함
            viewCookie.setMaxAge(0);        // 유효기간을 0으로 설정 (삭제 핵심!)
            resp.addCookie(viewCookie);   // 응답에 실어서 브라우저로 전송
        }

        // 리다이렉트
        resp.sendRedirect("/login_0209");

    }
    private Cookie findCookie(Cookie[] cookies, String cookieName) {

        Cookie targetCookie = null;

        if(cookies != null && cookies.length > 0) {
            for(Cookie ck: cookies) {
                if(ck.getName().equals(cookieName)) {
                    targetCookie = ck;
                    break;
                } //if
            } //for
        } // if

        // 찾고자 하는 쿠키가 없는 경우, 새로 쿠키를 생성해서, 반환.
        if (cookies != null && cookies.length > 0) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(cookieName)) {
                    return ck; // 찾으면 바로 반환
                }
            }
        }
        return null; // 못 찾으면 null 반환 (새로 만들지 않음)

    }
}

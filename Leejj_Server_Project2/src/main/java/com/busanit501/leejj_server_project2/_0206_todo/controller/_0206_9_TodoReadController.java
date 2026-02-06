package com.busanit501.leejj_server_project2._0206_todo.controller;

import com.busanit501.leejj_server_project2._0206_todo.dto._0206_6_TodoDTO;
import com.busanit501.leejj_server_project2._0206_todo.service._0206_2_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="_0206_9_TodoReadController", urlPatterns = "/todo/read_0206")
public class _0206_9_TodoReadController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 현재, 작업하는 파일 어디인지 , 서버 콘솔에 출력
        log.info("/todo/read_0206, get으로 요청 처리함. ");
        // 임시로 하나 조회할 더미 데이터 지정. (더미 데이터 임의로 100번 지정)
        // 웹브라우저에서, 주소 요청 : http://localhost:8080/todo/read_0206?tno=1
        // 서버는 , 웹에서 전달한 데이터를 가져오기.
//        req.getParameter("tno") => 문자열이기 때문에, 우리는 파싱해서, 다시 숫자 형태로 변경.
        //  Long.parseLong(문자열) -> 문자열 -> 숫자 변경.
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            // 서비스에서 만들었던, get 메서드에, tno 번호를 전달해서, 임시 데이터를 가져오기.
            _0206_6_TodoDTO todoDTO  = _0206_2_TodoService.INSTANCE.get(tno);
            // 데이터를 전달 준비1
            req.setAttribute("dto", todoDTO);
            // 화면에 전달
            req.getRequestDispatcher("/WEB-INF/_0206_todo/_3_todoRead.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read error");
        }

    }

}

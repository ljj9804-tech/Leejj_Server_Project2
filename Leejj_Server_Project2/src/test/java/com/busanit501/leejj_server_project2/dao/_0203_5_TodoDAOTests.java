package com.busanit501.leejj_server_project2.dao;

import com.busanit501.leejj_server_project2._0203_todo.dao._0203_4_TodoDAO;
import com.busanit501.leejj_server_project2._0203_todo.domain._0203_1_TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class _0203_5_TodoDAOTests {

    //준비물
    // 1) 디비 서버에 연결해서, 시간을 가져오는 기능을 가지고 있는 클래스 이용하기.
    // 주입.
    private _0203_4_TodoDAO todoDAO;

    // 2) 테스트를 할 때, 항상 todoDAO 객체 필요해서,
    // 각 메서드가 실행되기 전에, 미리 생성하는 코드
    @BeforeEach
    public void ready() {
        // 각 각의 단위테스트 메서드가 실행되기전에, 생성자 호출, 객체를 인스턴스화를 한다.
        todoDAO = new _0203_4_TodoDAO();
    }

    // 실제 테스트, 메서드
    @Test
    public void testTime() throws Exception {
        System.out.println("현재 시간 : " + todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        _0203_1_TodoVO vo = _0203_1_TodoVO.builder()
                .title("샘플제목22")
                .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(vo);
    }

    @Test
    public void testList() throws Exception {
        List<_0203_1_TodoVO> list = todoDAO.selectAll();
        // 콘솔에, 반복문으로 출력 해보기.
        // @ToString
        // System.out.println(vo)
        // 해당 객체를 sout 으로 출력하면, 우리가 지정한 데이터 값으로 출력이 됩니다.
        list.forEach(vo -> System.out.println(vo));

    }

    // 하나 조회
    @Test
    public void testSelectOne() throws Exception {
        // 조회할 tno 를 알고 있음.
        Long tno = 4L;
        // 조회
        _0203_1_TodoVO todoVO = todoDAO.selectOne(tno);
        System.out.println("하나 조회 결과 : " + todoVO);

    }

    //수정
    @Test
    public void testUpdateOne() throws Exception {
        // 수정할 tno 번호를 알고 있음.
        // 수정할 데이터도 가지고 있음.
        // 화면으로부터, 수정할 데이터를 받아서 작업을 할 예정.
        // 임시 데이터 생성.
        _0203_1_TodoVO todoVO = _0203_1_TodoVO.builder()
                .tno(4L)
                .title("수정 테스트")
                .dueDate(LocalDate.of(2026,2,2))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);


    }

    // 삭제
    @Test
    public void testDeleteOne() throws Exception {
        // 삭제할 번호를 알고 있다. 각자 디비에 있는 tno 번호를 이용하기.
        Long tno = 7L;
        todoDAO.deleteOne(tno);
    }


}

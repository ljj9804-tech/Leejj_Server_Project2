package com.busanit501.leejj_server_project2.springex_new_0219_keep.mapper;

import com.busanit501.leejj_server_project2.springex_new_0219_keep.domain.TodoVO;
import com.busanit501.leejj_server_project2.springex_new_0219_keep.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    //페이지네이션 작업
    //목록 조회하기
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    //전체 갯수 구하기
    int getCount(PageRequestDTO pageRequestDTO);
}

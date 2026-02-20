package com.busanit501.leejj_server_project2.springex_new_0219_keep.mapper;

import com.busanit501.leejj_server_project2.springex_new_0219_keep.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

}

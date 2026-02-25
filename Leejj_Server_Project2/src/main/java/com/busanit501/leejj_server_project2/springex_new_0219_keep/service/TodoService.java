package com.busanit501.leejj_server_project2.springex_new_0219_keep.service;

import com.busanit501.leejj_server_project2.springex_new_0219_keep.dto.PageRequestDTO;
import com.busanit501.leejj_server_project2.springex_new_0219_keep.dto.PageResponseDTO;
import com.busanit501.leejj_server_project2.springex_new_0219_keep.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void update(TodoDTO todoDTO);

    //페이징 처리 목록 조회
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

}

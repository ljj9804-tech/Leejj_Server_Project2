package com.busanit501.leejj_server_project2.springex_new_0219_keep.service;

import com.busanit501.leejj_server_project2.springex_new_0219_keep.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();
}

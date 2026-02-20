package com.busanit501.leejj_server_project2.springex_new_0219_keep.service;

import com.busanit501.leejj_server_project2.springex_0213_keep.dto.TodoDTO;
import com.busanit501.leejj_server_project2.springex_new_0219_keep.domain.TodoVO;
import com.busanit501.leejj_server_project2.springex_new_0219_keep.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info("서비스 작업: insert 기능 작업중. ");
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info("서비스 작업: insert 기능 변환된 todoVO : " + todoVO);
        todoMapper.insert(todoVO);
    }
}

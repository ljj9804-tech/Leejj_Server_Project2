package com.busanit501.leejj_server_project2.springex_0212.sample.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("select now()")
    String getTime();
}

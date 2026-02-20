package com.busanit501.leejj_server_project2.springex_new_0219_keep.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//서버 시작 시 설정을 담당하는 클래스
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
        // dto <-> vo 클래스의 멤버의 일치 여부를 체크함.
        .setFieldMatchingEnabled(true)
        // 접근은 private 까지 가능하게
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        // 매칭시, 검사시, 엄격하게 검사함.
        .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}

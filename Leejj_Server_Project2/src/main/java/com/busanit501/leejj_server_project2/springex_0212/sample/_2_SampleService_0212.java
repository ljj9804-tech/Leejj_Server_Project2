package com.busanit501.leejj_server_project2.springex_0212.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class _2_SampleService_0212 {
    @Qualifier("normal")
    private final _1_SampleDAO_0212 sampleDAO0212;
}

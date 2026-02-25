package com.busanit501.leejj_server_project2.springex_new_0219_keep.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    // 준비물
    // 1)페이지 번호 ,
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    // 2) 페이지 당 보여줄 갯수 ,
    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String link;

    public String getLink() {
        if(link == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }

    // 3) 몇개를 건너띄기 할건지.
    public int getSkip() {
        return (page -1) * 10;
    }


    //검색 기능 준비물
    private String[] types; //검색 타입
    private String keyword; //검색어
    private boolean finished; //완료여부로 조회

    private LocalDate from; //기간 지정 from~
    private LocalDate to; //기간 지정 ~to


    public boolean checkType(String type){
        if(types == null || types.length ==0) {
            return  false;
        }
        boolean result = Arrays.stream(types).anyMatch(type::equals);
        return result;
    }

}

package com.busanit501.leejj_server_project2.todo_2;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum _4_MenuService {
    INSTANCE; // static final 생략이 되어있다.

    // 기능구현,
    // 글쓰기
    public void register(_3_MenuDTO todoDTO) {
        System.out.println("서비스 기능, 글쓰기 기능, " +
                "사용자가 일정을 입력하면, todoDTO 라는 객체에 담겨서, 전달을 받습니다." +
                "꺼내서 사용하면됩니다. 뼈대만 구성.");
        System.out.println("todoDTO : " + todoDTO);
    }
    // 목록조회
    public List<_3_MenuDTO> getList() {
        // 하드코딩, 더미 데이터로, 10개만 샘플 등록,
        // 반복문으로
        List<_3_MenuDTO> todoDTOS = IntStream.range(0,10).mapToObj(
                i -> {
                    // todo 하나가, todoDTO 객체. 임시 객체 생성해서, 여기에 더미 값을 담기.
                    _3_MenuDTO dto = new _3_MenuDTO();
                    dto.setTno((long)i);
                    dto.setTitle("Todo.." + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }
        ).collect(Collectors.toList());// mapToObj 닫기 태그, 반복문으로 각각의 todo 객체를 생성해서, 리스트로 만들기.
        return todoDTOS;

    } //getList 닫기

    //Todo 조회
    public _3_MenuDTO get(Long tno) {
        // 반환할 임시 객체 생성
        _3_MenuDTO dto = new _3_MenuDTO();
        // 전달 받은  tno 번호로 임시 번호 설정,
        dto.setTno(tno);
        // 임시 제목
        dto.setTitle("샘플 Todo 더미 데이터1");
        // 임시 날짜, 현재 날짜,
        dto.setDueDate(LocalDate.now());
        // 임시 완료 여부,
        dto.setFinished(true);

        return dto;
    }


} //_4_TodoService 닫기

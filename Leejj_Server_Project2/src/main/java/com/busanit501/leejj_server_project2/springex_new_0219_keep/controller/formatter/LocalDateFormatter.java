package com.busanit501.leejj_server_project2.springex_new_0219_keep.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    //문자열 타입 -> LocalDate 타입으로 변경하는 기능
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        LocalDate localDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate;
    }

    //위 기능과 반대로 변경
    @Override
    public String print(LocalDate object, Locale locale) {
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
        return date;
    }
}

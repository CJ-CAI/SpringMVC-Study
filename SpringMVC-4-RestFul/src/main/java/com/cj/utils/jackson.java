package com.cj.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class jackson {

    public static ObjectMapper get_jacksonMapper(){
        return  get_jacksonMapper("yyyy-MM-dd HH:mm:ss");
    }
    public static ObjectMapper get_jacksonMapper(String DateFormat){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper;
    }
}

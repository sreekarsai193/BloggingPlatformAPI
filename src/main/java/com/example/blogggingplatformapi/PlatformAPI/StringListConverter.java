package com.example.blogggingplatformapi.PlatformAPI;

import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String Split_char = ",";
    @Override
    public String convertToDatabaseColumn(List<String> stringlist) {
        return stringlist!=null?String.join(Split_char,stringlist):null;
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        return (s!=null)?new ArrayList<>(Arrays.asList(s.split(Split_char))):new ArrayList<String>();
    }
}

package com.jalanocca.bat_backend.model.dto;

public class GenericResponseDto {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public static GenericResponseDto success(String message) {
        GenericResponseDto response = new GenericResponseDto();
        response.setCode("200");
        response.setMessage(message);
        return response;
    }

    public static GenericResponseDto error(String message) {
        GenericResponseDto response = new GenericResponseDto();
        response.setCode("500");
        response.setMessage(message);
        return response;
    }
}
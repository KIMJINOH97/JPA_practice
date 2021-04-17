package com.relation.jpa_practice.controller.dto;

import lombok.Getter;

@Getter
public class ApiForm<T>{
    private final T data;
    private final String error;

    ApiForm(T data, String error){
        this.data = data;
        this.error = error;
    }

    public static <T> ApiForm<T> succed(T data){
        return new ApiForm<T>(data, null);
    }

    public static ApiForm<?> fail(String error){
        return new ApiForm(null, error);
    }

    public static ApiForm<?> fail(Throwable throwable){
        return new ApiForm<>(null, throwable.getMessage());
    }

}

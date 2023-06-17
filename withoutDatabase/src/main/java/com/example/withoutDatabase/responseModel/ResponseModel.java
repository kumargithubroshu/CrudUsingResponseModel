package com.example.withoutDatabase.responseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResponseModel<T> {
    // status, message, data
    private Integer status;
    private String message;
    private T data;
}

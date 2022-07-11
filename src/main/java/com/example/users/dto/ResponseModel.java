package com.example.users.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tribeck
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private int result;
    private Object data;
    private Object errMessage;

    public ResponseModel(int result) {
        this.result = result;
    }

    public ResponseModel(int result, Object data) {
        this.result = result;
        this.data = data;
    }

    public ResponseModel(int result, Object data, Object errMessage) {
        this.result = result;
        this.data = data;
        this.errMessage = errMessage;
    }
}

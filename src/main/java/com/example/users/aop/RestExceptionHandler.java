package com.example.users.aop;

import com.example.users.dto.ResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler  {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleBindException(
            BindException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("result", 1);
        List<String> fields = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getField).collect(Collectors.toList());
        List<FieldError> fieldErrors =  ex.getBindingResult().getFieldErrors();
        //Get all errors
        Map<String, List<String>> map = new HashMap<>();
        for (String field: fields) {
            List<String> messages = new ArrayList<>();
            for (FieldError error: fieldErrors) {
                if (field.equals(error.getField())){
                    messages.add(error.getDefaultMessage());
                }
            }
            map.put(field, messages);
        }
        body.put("errMessage", map);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String code : entry.getValue()) {
                System.out.println("Loi"+ code);
//                MessageDTO messageDTO = messageInfoDao.getMessageWithCode(code);
//                if (messageDTO != null) {
//                    log.info(Constant.LOG_VALIDATE, messageDTO.getMessageContent(), entry.getKey());
//                } else {
//                    log.info(Constant.LOG_VALIDATE,  "Message code not exist: " + code, entry.getKey());
//                }
            }
        }

        return new ResponseEntity<>(body, null, HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherException(HttpServletRequest request, Exception ex) {
//        CommonUtil.commonLogException(ex);
        return new ResponseEntity<>(
                new ResponseModel(1, null, "Constant.CM9007"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}

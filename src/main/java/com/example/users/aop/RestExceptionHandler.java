package com.example.users.aop;

import com.example.users.dto.ResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("result", 1);
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
            }
        }

        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherException(HttpServletRequest request, Exception ex) {
        return new ResponseEntity<>(
                new ResponseModel(1, null, "Constant.CM9007"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handlingAuthorizeError(Exception e) {
        e.printStackTrace();
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handlingAccessDeniedException(Exception e) {
        e.printStackTrace();
    }
}

package com.example.users.aop;

import com.example.users.session.UserSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerInterceptor {
    private final UserSession userSession;

    public ControllerInterceptor(UserSession userSession) {
        this.userSession = userSession;
    }

    @Before("within(com.example.users.controller.*)")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (!"/authenticate".equals(request.getRequestURI())
        ){
            if (this.userSession.getUserId() == null || this.userSession.getRoleId()== null) {
                throw new UsernameNotFoundException("session not found");
            }
        }
    }
}

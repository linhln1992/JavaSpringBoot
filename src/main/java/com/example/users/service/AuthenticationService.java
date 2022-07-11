package com.example.users.service;

import com.example.users.session.UserSession;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    boolean checkRoleAdmin();
    UserSession getSession();
}

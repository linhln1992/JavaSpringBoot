package com.example.users.service.impl;

import com.example.users.service.AuthenticationService;
import com.example.users.session.UserSession;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserSession userSession;

    public AuthenticationServiceImpl(UserSession userSession) {
        this.userSession = userSession;
    }
    @Override
    public boolean checkRoleAdmin() {
        UserSession userSession = getSession();
        return userSession.getRoleId() == 1;
    }

    @Override
    public UserSession getSession() {
        if (this.userSession.getUserId() == null || this.userSession.getRoleId()== null) {
            throw new UsernameNotFoundException("session not found");
        }
        return new UserSession(userSession.getUserId(), userSession.getRoleId());
    }
}

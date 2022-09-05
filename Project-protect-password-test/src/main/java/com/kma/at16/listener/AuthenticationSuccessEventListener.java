package com.kma.at16.listener;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.kma.at16.service.LoginAttemptService;

@Component
public class AuthenticationSuccessEventListener implements 
  ApplicationListener<AuthenticationSuccessEvent> {
    
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(final AuthenticationSuccessEvent e) {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            loginAttemptService.loginSucceeded();
        } else {
            loginAttemptService.loginSucceeded();
        }
    }
}
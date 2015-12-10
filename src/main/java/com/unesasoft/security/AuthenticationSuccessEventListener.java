package com.unesasoft.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private LoginAttemptService loginAttemptService;

    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();
        if (auth != null) {
            loginAttemptService.loginSucceeded(auth.getRemoteAddress());
        }
    }
}

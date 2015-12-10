package com.unesasoft.event;

import com.unesasoft.persistance.dto.UserDTO;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * Created by Slavyanin on 27.07.2015.
 */
@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final UserDTO user;

    public OnRegistrationCompleteEvent(UserDTO user, Locale locale, String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public UserDTO getUser() {
        return user;
    }
}

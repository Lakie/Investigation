package com.unesasoft.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Slavyanin on 27.07.2015.
 */
public interface UserDetailsService {
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}

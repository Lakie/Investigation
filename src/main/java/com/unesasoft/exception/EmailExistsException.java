package com.unesasoft.exception;

/**
 * Created by Slavyanin on 27.07.2015.
 */
public class EmailExistsException extends Throwable {

    public EmailExistsException(String message) {
        super(message);
    }
}

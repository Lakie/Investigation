package com.unesasoft.validation;

import com.unesasoft.annotations.PasswordMatches;
import com.unesasoft.dto.UserBean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Slavyanin on 27.07.2015.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserBean user = (UserBean) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}

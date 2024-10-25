package org.knj.taskhandle.domaine;

import lombok.Getter;
import org.apache.commons.validator.routines.EmailValidator;

@Getter
public class EmailAddress {
    private String email;

    public EmailAddress(String email) {

        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public void setEmail(String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

}

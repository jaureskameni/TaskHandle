package org.knj.taskhandle.domaine;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

@Getter
@Embeddable
@NoArgsConstructor
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

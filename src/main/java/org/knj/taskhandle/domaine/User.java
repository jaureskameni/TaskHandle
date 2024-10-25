package org.knj.taskhandle.domaine;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private UserId id;
    private Firstname firstname;
    private Lastname lastname;
    private Civility civility;
    private String Username;
    private Passowrd passowrd;
    private EmailAddress email;
    private List<RoleName> roles = new ArrayList<>();
}

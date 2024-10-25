package org.knj.taskhandle.domaine;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;

import static org.knj.taskhandle.domaine.Privilege.READ_PRIVILEGE;

public enum Role {
    ADMIN(
            Set.of(READ_PRIVILEGE, WRITE_PRIVILEGE, UPDATE_PRIVILEGE, DELETE_PRIVILEGE)
    ),
    USER(
            Set.of(READ_PRIVILEGE)
    );

    private final Set<Privilege> privileges;

    public List<SimpleGrantedAuthority> getAuthorities(){
        List<SimpleGrantedAuthority> authorities =
                new java.util.ArrayList<>(getPrivileges()
                        .stream()
                        .map(
                                privilege -> new SimpleGrantedAuthority(privilege.name())
                        )
                        .toList());
        authorities.add(
                new SimpleGrantedAuthority("ROLE_"+this.name())
        );
        return authorities;
    }
}

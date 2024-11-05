package org.knj.taskhandle.domaine;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_user")
public class User /*implements UserDetails*/{
    @Builder.Default
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "c_id"))
    private UserId id = new UserId();

    @Embedded
    @Column(name = "c_firstname")
    private Firstname firstname;

    @Embedded
    @Column(name = "c_lastname")
    private Lastname lastname;

    @Embedded
    @Column(name = "c_civility")
    private Civility civility;

    @Column(name = "c_user_name")
    private String username;

    @Embedded
    @Column(name = "c_password")
    private Password password;

    @Embedded
    @Column(name = "c_email")
    private EmailAddress email;

   /* @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = RoleName.class)
    @Builder.Default
    private Set<RoleName> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
                .stream()
                .flatMap(roleName -> roleName.getAuthorities().stream())
                .toList();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password.getValue();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/
}

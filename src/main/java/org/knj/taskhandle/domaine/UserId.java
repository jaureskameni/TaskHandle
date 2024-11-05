package org.knj.taskhandle.domaine;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class UserId {
    @NotNull
    @Builder.Default
    private String value = UUID.randomUUID().toString();
    public UserId(@NotNull String value){
        this.value = value;
    }
    public UserId(@NotNull UUID value){
        this.value = value.toString();
    }
public UUID toUUID(){
    return UUID.fromString(value);
}
}

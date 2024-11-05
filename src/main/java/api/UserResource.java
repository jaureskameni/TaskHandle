package api;

import lombok.RequiredArgsConstructor;
import org.knj.th.api.UserApi;
import org.knj.th.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserResource implements UserApi {
    private final UserService userService;

    @Override
    public ResponseEntity<UUID> createUser(UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(userDTO));
    }
}

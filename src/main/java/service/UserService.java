package service;

import jakarta.transaction.Transactional;
import org.knj.th.dto.UserDTO;

import java.util.UUID;

public class UserService {
    @Transactional
    public UUID createUser(UserDTO userDTO) {
        return null;
    }
}

package org.knj.taskhandle.api;

import api.UserResource;
import org.junit.jupiter.api.Test;
import org.knj.th.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import service.UserService;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@WebFluxTest(UserResource.class)
class UserResourceTest extends ResourceTest {

    @MockBean
    private UserService userService;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createUser() {

        var expected = UUID.randomUUID();
        var userDTO = new UserDTO();
        when(userService.createUser(userDTO)).thenReturn(expected);

        var resultUnderTest =
                webTestClient
                        .post()
                        .uri("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(userDTO)
                        .exchange()
                        .expectStatus()
                        .isCreated()
                        .expectBody(UUID.class)
                        .returnResult()
                        .getResponseBody();

        assertThat(resultUnderTest).isEqualTo(expected);
    }
}
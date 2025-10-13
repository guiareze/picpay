package br.com.guiareze.picpay.controller.adapter;

import br.com.guiareze.picpay.controller.dto.UserCreationRequest;
import br.com.guiareze.picpay.controller.dto.UserCreationResponse;
import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.core.mapper.UserMapper;
import br.com.guiareze.picpay.core.ports.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserCreationResponse> createUser(@RequestBody UserCreationRequest userCreationRequest) {
        log.info("Controller  - Creating user: {}", userCreationRequest);
        User serviceResponse = service.createUser(UserMapper.toDomain(userCreationRequest));
        UserCreationResponse userCreationResponse = UserMapper.toResponse(serviceResponse);
        log.info("Controller  - User created: {}", userCreationResponse);
        return ResponseEntity.ok(userCreationResponse);
    }

}

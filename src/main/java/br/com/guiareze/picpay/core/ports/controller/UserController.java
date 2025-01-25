package br.com.guiareze.picpay.core.ports.controller;

import br.com.guiareze.picpay.controller.dto.request.UserRequest;
import br.com.guiareze.picpay.controller.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserController {

    ResponseEntity<UserResponse> createUser(UserRequest userRequest);

}

package br.com.guiareze.picpay.controller.adapter;

import br.com.guiareze.picpay.controller.dto.request.UserRequest;
import br.com.guiareze.picpay.controller.dto.response.UserResponse;
import br.com.guiareze.picpay.core.enums.UserType;
import br.com.guiareze.picpay.core.mapper.UserMapper;
import br.com.guiareze.picpay.core.ports.controller.UserController;
import br.com.guiareze.picpay.core.ports.core.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest){

        var userModel = Objects.equals(userRequest.userType(), UserType.SALESPERSON) ?
                UserMapper.INSTANCE.toSalesPerson(userRequest) :
                UserMapper.INSTANCE.toCommonUser(userRequest);

        var userCreated = userService.createUser(userModel);

        var userResponse = UserMapper.INSTANCE.toUserResponse(userCreated);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

}

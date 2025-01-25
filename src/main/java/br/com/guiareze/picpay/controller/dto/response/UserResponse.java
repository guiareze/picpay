package br.com.guiareze.picpay.controller.dto.response;

import java.util.UUID;

public record UserResponse (

        UUID id,
        String name,
        String document,
        String email,
        AccountResponse account

)
{}

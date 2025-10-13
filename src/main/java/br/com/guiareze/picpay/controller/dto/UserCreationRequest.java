package br.com.guiareze.picpay.controller.dto;

import br.com.guiareze.picpay.controller.enumeration.Category;

public record UserCreationRequest(
        String name,
        String document,
        String email,
        String password,
        Category category
) {
}

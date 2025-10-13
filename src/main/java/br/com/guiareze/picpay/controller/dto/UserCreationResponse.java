package br.com.guiareze.picpay.controller.dto;

import br.com.guiareze.picpay.controller.enumeration.Category;

public record UserCreationResponse(
        Long id,
        String name,
        String document,
        String email,
        Category category
) {
}

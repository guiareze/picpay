package br.com.guiareze.picpay.core.domain;

import br.com.guiareze.picpay.controller.enumeration.Category;

public record User(
        Long id,
        String name,
        String document,
        String email,
        String password,
        Category category
) {
}

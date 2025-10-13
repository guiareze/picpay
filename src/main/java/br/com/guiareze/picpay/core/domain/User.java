package br.com.guiareze.picpay.core.domain;

import br.com.guiareze.picpay.controller.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String document;
    private String email;
    private String password;
    private Category category;

}

package br.com.guiareze.picpay.controller.dto.request;

import br.com.guiareze.picpay.core.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UserRequest(

        @NotBlank(message = "Field name cannot be null or blank")
        String name,

        @NotBlank(message = "Field document cannot be null or blank")
        @CPF
        String document,

        @NotBlank(message = "Field email cannot be null or blank")
        @Email
        String email,

        @NotBlank(message = "Field password cannot be null or blank")
        String password,

        @NotNull(message = "Field userType cannot be null or blank")
        UserType userType

) {
}

package br.com.guiareze.picpay.core.mapper;

import br.com.guiareze.picpay.controller.dto.UserRequest;
import br.com.guiareze.picpay.controller.dto.UserResponse;
import br.com.guiareze.picpay.controller.enumeration.Category;
import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.persistence.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserRequest request){
        return new User(
                null,
                request.name(),
                request.document(),
                request.email(),
                request.password(),
                request.category()
        );
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.id().toString(),
                user.name(),
                user.document(),
                user.email(),
                user.category()
        );
    }

    public static UserEntity toEntity(User user){
        return new UserEntity(
                null,
                user.name(),
                user.document(),
                user.email(),
                user.password(),
                user.category().toString()
        );
    }

    public static User toDomain(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getDocument(),
                entity.getEmail(),
                entity.getPassword(),
                Category.valueOf(entity.getCategory())
        );
    }

}

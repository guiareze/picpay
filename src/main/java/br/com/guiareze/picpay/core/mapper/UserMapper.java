package br.com.guiareze.picpay.core.mapper;

import br.com.guiareze.picpay.controller.dto.UserCreationRequest;
import br.com.guiareze.picpay.controller.dto.UserCreationResponse;
import br.com.guiareze.picpay.controller.enumeration.Category;
import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.persistence.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserCreationRequest request){
        return new User(
                null,
                request.name(),
                request.document(),
                request.email(),
                request.password(),
                request.category()
        );
    }

    public static UserCreationResponse toResponse(User user){
        return new UserCreationResponse(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getEmail(),
                user.getCategory()
        );
    }

    public static UserEntity toEntity(User user){
        return new UserEntity(
                null,
                user.getName(),
                user.getDocument(),
                user.getEmail(),
                user.getPassword(),
                user.getCategory().toString()
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

package br.com.guiareze.picpay.core.mapper;

import br.com.guiareze.picpay.controller.dto.UserRequest;
import br.com.guiareze.picpay.controller.dto.UserResponse;
import br.com.guiareze.picpay.controller.enumeration.Category;
import br.com.guiareze.picpay.core.domain.Account;
import br.com.guiareze.picpay.core.domain.CommomUser;
import br.com.guiareze.picpay.core.domain.Logist;
import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.persistence.entity.UserEntity;

public class UserMapper {

    // TODO - Ajustar tipagem da chave primaria de Long para String (UUID) ou de outra forma

    public static User toDomain(UserRequest request){

        if (request.category().equals(Category.COMMOM)){
            return new CommomUser(
                    null,
                    request.name(),
                    request.document(),
                    request.email(),
                    request.password(),
                    request.category(),
                    new Account()
            );
        } else {
            return new Logist(
                    null,
                    request.name(),
                    request.document(),
                    request.email(),
                    request.password(),
                    request.category(),
                    new Account()
            );
        }
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getId().toString(),
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
        if (entity.getCategory().equals(Category.COMMOM.toString())){
            return new CommomUser(
                    entity.getId(),
                    entity.getName(),
                    entity.getDocument(),
                    entity.getEmail(),
                    entity.getPassword(),
                    Category.valueOf(entity.getCategory()),
                    null
            );
        } else {
            return new Logist(
                    entity.getId(),
                    entity.getName(),
                    entity.getDocument(),
                    entity.getEmail(),
                    entity.getPassword(),
                    Category.valueOf(entity.getCategory()),
                    null
            );
        }
    }

}

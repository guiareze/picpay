package br.com.guiareze.picpay.core.mapper;

import br.com.guiareze.picpay.controller.dto.request.UserRequest;
import br.com.guiareze.picpay.controller.dto.response.UserResponse;
import br.com.guiareze.picpay.core.domain.CommonUser;
import br.com.guiareze.picpay.core.domain.SalesPerson;
import br.com.guiareze.picpay.core.domain.User;
import br.com.guiareze.picpay.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    CommonUser toCommonUser(UserRequest userRequest);
    SalesPerson toSalesPerson(UserRequest userRequest);

    @Mapping(source = "account.id", target = "account.id")
    UserResponse toUserResponse(User user);

    UserEntity toUserEntity(User user);

}

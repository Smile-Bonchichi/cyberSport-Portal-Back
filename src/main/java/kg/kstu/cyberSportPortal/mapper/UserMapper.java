package kg.kstu.cyberSportPortal.mapper;

import kg.kstu.cyberSportPortal.dto.request.user.UserDtoRequest;
import kg.kstu.cyberSportPortal.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUserEntity(UserDtoRequest userDtoRequest);

    User toUserEntity(UserSignInDtoRequest userSignInDtoRequest);
}

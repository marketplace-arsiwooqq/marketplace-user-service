package com.arsiwooqq.userservice.mapper;

import com.arsiwooqq.userservice.generated.User;
import com.arsiwooqq.userservice.dto.UserCreateRequest;
import com.arsiwooqq.userservice.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserGrpcMapper {

    @Mapping(target = "birthDate", expression = "java(com.arsiwooqq.userservice.dto.serialization.LocalDateDeserializer.deserialize(request.getBirthDate()))")
    UserCreateRequest toRequest(User.UserCreateRequest request);

    default User.UserResponse toResponse(UserResponse response) {
        return User.UserResponse.newBuilder()
                .setUserId(response.userId())
                .setName(response.name())
                .setSurname(response.surname())
                .setBirthDate(response.birthDate().toString())
                .setEmail(response.email())
                .build();
    }
}

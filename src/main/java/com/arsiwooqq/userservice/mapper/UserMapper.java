package com.arsiwooqq.userservice.mapper;

import com.arsiwooqq.userservice.dto.UserCreateRequest;
import com.arsiwooqq.userservice.dto.UserResponse;
import com.arsiwooqq.userservice.dto.UserUpdateRequest;
import com.arsiwooqq.userservice.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CardMapper.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cards", ignore = true)
    User toEntity(UserCreateRequest request);
    UserResponse toResponse(User user);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "cards", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UserUpdateRequest request, @MappingTarget User user);
}

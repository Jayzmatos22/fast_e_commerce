package com.ecommerce.backend.model;


import com.ecommerce.backend.dtos.user.UserResponse;
import com.ecommerce.backend.dtos.user.UserUpdateRequest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserResponse toResponse(User user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "phoneUser", source = "phoneUser")
    @Mapping(target = "birthDate", source = "birthDate")
    void updateEntityFromDto(UserUpdateRequest request, @MappingTarget User entity);
}

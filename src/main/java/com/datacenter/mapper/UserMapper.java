package com.datacenter.mapper;

import com.datacenter.da.entity.User;
import com.datacenter.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}

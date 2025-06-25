package com.datacenter.service.userService;

import com.datacenter.dto.UserDto;
import com.datacenter.da.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    Optional<User> findByUsername(String username);
    UserDto createUser(UserDto dto, String rawPassword);


    void deleteUser(Long id);

    UserDto updateUser(Long id, UserDto dto);
}

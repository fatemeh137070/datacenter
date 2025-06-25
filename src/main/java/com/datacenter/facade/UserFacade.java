package com.datacenter.facade;

import com.datacenter.da.entity.User;
import com.datacenter.dto.UserDto;
import com.datacenter.mapper.UserMapper;
import com.datacenter.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserFacade(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public List<UserDto> findAll() {
        return userService.findAll();
    }

    public Optional<UserDto> findById(Long id) {
        return userService.findByUsername(id.toString()) // اگر بخوایم بر اساس username نباشه باید متد جدید داشته باشیم findById
                .map(userMapper::toDto);
    }

    public UserDto save(UserDto dto, String rawPassword) {
        return userService.createUser(dto, rawPassword);
    }

    public UserDto update(Long id, UserDto dto) {
        return userService.updateUser(id, dto);
    }

    public void delete(Long id) {
        userService.deleteUser(id);
    }

    // اگر میخوایم username جستجو کنیم، این متد رو اضافه کنیم:
    public Optional<UserDto> findByUsername(String username) {
        return userService.findByUsername(username)
                .map(userMapper::toDto);
    }
}
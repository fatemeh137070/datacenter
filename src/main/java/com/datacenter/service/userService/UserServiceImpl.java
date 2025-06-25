package com.datacenter.service.userService;

import com.datacenter.da.entity.User;
import com.datacenter.da.repository.UserRepository;
import com.datacenter.dto.UserDto;
import com.datacenter.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto createUser(UserDto dto, String rawPassword) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(rawPassword));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        existing.setUsername(dto.getUsername());
        existing.setRole(dto.getRole());
        // برای تغییر رمز عبور جداگانه متد می‌زنیم، اینجا فقط نام و نقش آپدیت میشن
        userRepository.save(existing);
        return userMapper.toDto(existing);
    }
}

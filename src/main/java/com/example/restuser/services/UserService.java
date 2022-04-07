package com.example.restuser.services;

import com.example.restuser.dto.UserDto;
import com.example.restuser.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    void saveUser(UserDto userDto);
    List<User> findAll();
    Optional<User> findByid(long id);
    void deleteUser(long id);

}

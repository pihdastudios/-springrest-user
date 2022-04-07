package com.example.restuser.services;

import com.example.restuser.dto.UserDto;
import com.example.restuser.entity.User;
import com.example.restuser.repository.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        var user = new User(userDto.getId(), userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdAsc();
    }

    public Optional<User> findByid(long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }
}

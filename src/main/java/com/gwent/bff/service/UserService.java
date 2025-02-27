package com.gwent.bff.service;

import com.gwent.bff.repository.UserRepository;
import com.gwent.bff.dto.requets.UserRequestDTO;
import com.gwent.bff.dto.response.UserResponseDTO;
import com.gwent.bff.mapper.UserMapper;
import com.gwent.bff.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        User user = userMapper.toEntityFromRequest(requestDTO);

        try {
            user = userRepository.save(user);
            return userMapper.toResponseFromEntity(user);
        } catch (Exception e) {
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }
}

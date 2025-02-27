package com.gwent.bff.mapper;

import com.gwent.bff.dto.requets.UserRequestDTO;
import com.gwent.bff.dto.response.UserResponseDTO;
import com.gwent.bff.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntityFromRequest(UserRequestDTO request){
        User user = new User();
        user.setId(request.getId());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setGameId(request.getGameId());
        user.setUserCode(request.getUserCode());
        return user;
    }
    public UserResponseDTO toResponseFromEntity(User user){
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setGameId(user.getGameId());
        response.setUserCode(user.getUserCode());
        return response;
    }
}

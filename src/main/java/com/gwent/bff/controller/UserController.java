package com.gwent.bff.controller;


import com.gwent.bff.dto.requets.UserRequestDTO;
import com.gwent.bff.dto.response.GenericResponseDTO;
import com.gwent.bff.dto.response.UserResponseDTO;
import com.gwent.bff.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
public class UserController {

    private UserService userService;
    @Value("${spring.application.name}")
    private String SERVICE_NAME;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("v1/user")
    public ResponseEntity<GenericResponseDTO> signUp(@Valid @RequestBody UserRequestDTO requestDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            GenericResponseDTO<String> response = new GenericResponseDTO<>(SERVICE_NAME, HttpStatus.BAD_REQUEST.value(), errorMessage);
            return ResponseEntity.badRequest().body(response);
        }

        UserResponseDTO responseDTO = userService.save(requestDTO);
        GenericResponseDTO<UserResponseDTO> response = new GenericResponseDTO<>(
                SERVICE_NAME,
                HttpStatus.OK.value(),
                responseDTO
        );
        return ResponseEntity.ok(response);
    }
    @PostMapping("v2/user")
    public ResponseEntity<GenericResponseDTO> signUpV2(@Valid @RequestBody UserRequestDTO requestDTO, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            throw new Exception(errorMessage);
        }

        UserResponseDTO responseDTO = userService.save(requestDTO);
        GenericResponseDTO<UserResponseDTO> response = new GenericResponseDTO<>(
                SERVICE_NAME,
                HttpStatus.OK.value(),
                responseDTO
        );
        return ResponseEntity.ok(response);
    }
}

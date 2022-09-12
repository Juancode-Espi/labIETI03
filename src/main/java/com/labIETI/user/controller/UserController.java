package com.labIETI.user.controller;

import com.labIETI.user.dto.UserDto;
import com.labIETI.user.exception.UserNotFoundException;
import com.labIETI.user.mapper.UserMapper;
import com.labIETI.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> response = userService.getAll().stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById( @PathVariable Long id ){
        return new ResponseEntity<>(userMapper.toDto(userService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto){
        return new ResponseEntity<>(userMapper.toDto(userService
                .create(userMapper.toEntity(userDto))),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete( @PathVariable Long id){
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (UserNotFoundException ex){
            Logger.getLogger(ex.getMessage());
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update( @RequestBody UserDto userDto, @PathVariable Long id){
        try {
            UserDto userDtoResponse = userMapper.toDto(userService.update(userMapper
                    .toEntity(userDto),id));
            return new ResponseEntity<>(userDtoResponse,HttpStatus.ACCEPTED);
        }catch (UserNotFoundException ex){
            Logger.getLogger(ex.getMessage());
            return new ResponseEntity<>(new UserDto(),HttpStatus.OK);
        }

    }

}

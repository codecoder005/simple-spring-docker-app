package com.orgofarmsgroup.controller;

import com.orgofarmsgroup.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
@Slf4j
public class UserController {
    private static List<UserEntity> users = Arrays.asList(
            new UserEntity(101L, "John", "john@email.com")
    );

    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        try{
            log.info("UserController::get");
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }catch (Exception ex) {
            log.error("UserController::get::SOMETHING WENT WRONG");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody UserEntity user) {
        try{
            log.info("UserController::post");
            users.add(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }catch (Exception ex) {
            log.error("UserController::post::SOMETHING WENT WRONG");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }
}
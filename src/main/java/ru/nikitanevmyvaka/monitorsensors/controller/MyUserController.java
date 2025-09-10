package ru.nikitanevmyvaka.monitorsensors.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikitanevmyvaka.monitorsensors.model.MyUser;
import ru.nikitanevmyvaka.monitorsensors.service.MyUserDetailsService;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class MyUserController {

    private MyUserDetailsService service;


    @PostMapping("/new-user")
    public String createUser(@RequestBody @Valid MyUser user){
        service.createUser(user);
        return "user successfully saved";




    }




}

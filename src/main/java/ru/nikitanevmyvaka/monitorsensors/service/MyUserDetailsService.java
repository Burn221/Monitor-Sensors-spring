package ru.nikitanevmyvaka.monitorsensors.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nikitanevmyvaka.monitorsensors.configuration.MyUserDetails;
import ru.nikitanevmyvaka.monitorsensors.model.MyUser;
import ru.nikitanevmyvaka.monitorsensors.repository.MyUserRepository;

import java.util.Optional;

@Service

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> user= repository.findByName(username);

        return user.map(MyUserDetails:: new)
                .orElseThrow(()-> new UsernameNotFoundException("Username "+username+" not found"));
    }


    public void createUser(MyUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}

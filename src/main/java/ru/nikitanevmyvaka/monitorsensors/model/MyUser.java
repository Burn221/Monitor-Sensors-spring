package ru.nikitanevmyvaka.monitorsensors.model;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class MyUser {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name", unique = true)
    private String name;


    @Column(name="password")
    private String password;

    @Column(name="roles")
    private String roles;


}

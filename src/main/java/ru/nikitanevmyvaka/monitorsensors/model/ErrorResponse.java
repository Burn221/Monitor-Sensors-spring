package ru.nikitanevmyvaka.monitorsensors.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private String message;
    private String uri;
    private int code;
    private LocalDateTime timestamp;

}

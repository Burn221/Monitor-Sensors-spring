package ru.nikitanevmyvaka.monitorsensors.model;

import lombok.*;

@Getter
@Setter

public class Response {

    private String message;

    public Response(String message){
        this.message= message;
    }


}

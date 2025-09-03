package ru.nikitanevmyvaka.monitorsensors.exceptions;

public class MissingArgumentException extends RuntimeException {
    public MissingArgumentException(String message) {
        super(message);
    }
}

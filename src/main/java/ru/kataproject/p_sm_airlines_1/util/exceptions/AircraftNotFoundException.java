package ru.kataproject.p_sm_airlines_1.util.exceptions;

public class AircraftNotFoundException extends RuntimeException {
    public AircraftNotFoundException(String message) {
        super(message);
    }
}

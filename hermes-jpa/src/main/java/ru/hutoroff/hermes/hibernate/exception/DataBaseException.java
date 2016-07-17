package ru.hutoroff.hermes.hibernate.exception;

/**
 * Created by hutoroff on 17.07.16.
 */
public class DataBaseException extends Exception {

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

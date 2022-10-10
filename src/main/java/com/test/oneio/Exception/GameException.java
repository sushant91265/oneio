package com.test.oneio.Exception;

/* 
 * Custom exception class for FizzBuzz game.
 */
public class GameException extends RuntimeException {
    private String message;

    public GameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

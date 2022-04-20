package com.mlynarczyk.spokentime.domain;


public class WrongTimeFormatException extends RuntimeException{

    public WrongTimeFormatException(String message) {
        super(message);
    }

}

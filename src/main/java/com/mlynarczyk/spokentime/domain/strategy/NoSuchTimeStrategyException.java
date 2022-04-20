package com.mlynarczyk.spokentime.domain.strategy;

public class NoSuchTimeStrategyException extends RuntimeException {
    private static final String COLON = ":";

    public NoSuchTimeStrategyException(Integer hours, Integer minutes) {
        super(new StringBuffer(hours).append(COLON).append(minutes).toString());
    }
}

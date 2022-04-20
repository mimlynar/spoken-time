package com.mlynarczyk.spokentime;

public interface ConvertibleToSpokenTime {

    int _0 = 0;
    int _30 = 30;
    int _15 = 15;
    int _45 = 45;
    int _12 = 12;

    Integer getHours();

    Integer getMinutes();

    default boolean isFullHour() {
        return _0 == getMinutes();
    }

    default boolean isLessThanHalfHour() {
        return _30 > getMinutes();
    }

    default boolean isQuarterPast() {
        return _15 == getMinutes();
    }

    default boolean isQuarterTo() {
        return _45 == getMinutes();
    }

    default boolean isHalfHour() {
        return _30 == getMinutes();
    }

    default boolean isNoon() {
        return _12 == getHours() && _0 == getMinutes();
    }

    default boolean isMidnight() {
        return _0 == getHours() && _0 == getMinutes();
    }

    default boolean isFullTwelveHours() {
        return isMidnight() || isNoon();
    }

   default boolean isMoreThanHalfHour(){
        return getMinutes() > _30;
   };
}

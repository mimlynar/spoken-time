package com.mlynarczyk.spokentime;

import com.mlynarczyk.spokentime.domain.Time;
import com.mlynarczyk.spokentime.domain.strategy.FullHourStrategy;

public interface LanguageSpokenTimePrinter {

    SpokenTimeStrategy FIRST_STRATEGY = new FullHourStrategy();

    String print(Time time);

    default SpokenTimeStrategy getStrategy(ConvertibleToSpokenTime time) {
        return FIRST_STRATEGY.findStrategy(time);
    }

    String printFullTime(Time time);

    String printHalfHour(Time time);

    String printLessThanHalfHour(Time time);

    String printMidnight();

    String printMoreThanHalfHour(Time time);

    String printNoon();

    String printPastQuarter(Time time);

    String printQuarterTo(Time time);
}

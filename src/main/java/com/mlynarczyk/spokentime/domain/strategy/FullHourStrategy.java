package com.mlynarczyk.spokentime.domain.strategy;

import com.mlynarczyk.spokentime.SpokenTimeStrategy;
import com.mlynarczyk.spokentime.ConvertibleToSpokenTime;
import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;

public class FullHourStrategy implements SpokenTimeStrategy {

    @Override
    public SpokenTimeStrategy getNext(ConvertibleToSpokenTime convertible) {
        return new MidnightStrategy() ;
    }

    @Override
    public boolean meetCondition(ConvertibleToSpokenTime convertible) {
        return convertible.isFullHour() && !convertible.isFullTwelveHours();
    }

    @Override
    public String print(Time time, LanguageSpokenTimePrinter printer) {
        return printer.printFullTime(time);
    }

}

package com.mlynarczyk.spokentime.domain.strategy;

import com.mlynarczyk.spokentime.SpokenTimeStrategy;
import com.mlynarczyk.spokentime.ConvertibleToSpokenTime;
import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;

class LessThanHalfHourStrategy implements SpokenTimeStrategy {

    @Override
    public SpokenTimeStrategy getNext(ConvertibleToSpokenTime convertible) {
        return new HalfHourStrategy();
    }

    @Override
    public boolean meetCondition(ConvertibleToSpokenTime convertible) {
        return !convertible.isQuarterPast() && convertible.isLessThanHalfHour();
    }

    @Override
    public String print(Time time, LanguageSpokenTimePrinter printer) {
        return printer.printLessThanHalfHour(time);
    }

}

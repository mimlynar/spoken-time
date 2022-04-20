package com.mlynarczyk.spokentime.domain.strategy;

import com.mlynarczyk.spokentime.SpokenTimeStrategy;
import com.mlynarczyk.spokentime.ConvertibleToSpokenTime;
import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;

class MoreThanHalfHourStrategy implements SpokenTimeStrategy {

    @Override
    public SpokenTimeStrategy getNext(ConvertibleToSpokenTime convertible) {
        throw new NoSuchTimeStrategyException(convertible.getHours(), convertible.getMinutes());
    }

    @Override
    public boolean meetCondition(ConvertibleToSpokenTime convertible) {
        return !convertible.isQuarterTo() && convertible.isMoreThanHalfHour();
    }

    @Override
    public String print(Time time, LanguageSpokenTimePrinter printer) {
        return printer.printMoreThanHalfHour(time);
    }


}

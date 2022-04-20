package com.mlynarczyk.spokentime.domain.strategy;

import com.mlynarczyk.spokentime.SpokenTimeStrategy;
import com.mlynarczyk.spokentime.ConvertibleToSpokenTime;
import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;

class QuarterToStrategy implements SpokenTimeStrategy {

    @Override
    public SpokenTimeStrategy getNext(ConvertibleToSpokenTime convertible) {
        return new MoreThanHalfHourStrategy();
    }

    @Override
    public boolean meetCondition(ConvertibleToSpokenTime convertible) {
        return convertible.isQuarterTo();
    }

    @Override
    public String print(Time time, LanguageSpokenTimePrinter printer) {
        return printer.printQuarterTo(time);
    }

}

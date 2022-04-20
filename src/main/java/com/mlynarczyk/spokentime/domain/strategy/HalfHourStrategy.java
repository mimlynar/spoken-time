package com.mlynarczyk.spokentime.domain.strategy;

import com.mlynarczyk.spokentime.SpokenTimeStrategy;
import com.mlynarczyk.spokentime.ConvertibleToSpokenTime;
import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;

class HalfHourStrategy implements SpokenTimeStrategy {

    @Override
    public SpokenTimeStrategy getNext(ConvertibleToSpokenTime convertible) {
       return new QuarterToStrategy();
    }

    @Override
    public boolean meetCondition(ConvertibleToSpokenTime convertible) {
        return convertible.isHalfHour();
    }

    @Override
    public String print(Time time, LanguageSpokenTimePrinter printer) {
        return printer.printHalfHour(time);
    }


}

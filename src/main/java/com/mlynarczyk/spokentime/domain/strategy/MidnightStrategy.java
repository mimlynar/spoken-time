package com.mlynarczyk.spokentime.domain.strategy;

import com.mlynarczyk.spokentime.SpokenTimeStrategy;
import com.mlynarczyk.spokentime.ConvertibleToSpokenTime;
import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;

class MidnightStrategy implements SpokenTimeStrategy {

    @Override
    public SpokenTimeStrategy getNext(ConvertibleToSpokenTime convertible) {
        return new NoonStrategy();
    }

    @Override
    public boolean meetCondition(ConvertibleToSpokenTime convertible) {
        return convertible.isMidnight();
    }

    @Override
    public String print(Time time, LanguageSpokenTimePrinter printer) {
        return printer.printMidnight();
    }


}

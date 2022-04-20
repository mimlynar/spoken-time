package com.mlynarczyk.spokentime;

import com.mlynarczyk.spokentime.domain.Time;

public interface SpokenTimeStrategy {

    SpokenTimeStrategy getNext(ConvertibleToSpokenTime convertible);

    boolean meetCondition(ConvertibleToSpokenTime convertible);

    String print(Time time, LanguageSpokenTimePrinter printer);

    default SpokenTimeStrategy findStrategy(ConvertibleToSpokenTime convertible) {
        return meetCondition(convertible) ? this : getNext(convertible).findStrategy(convertible);
    }
}

package com.mlynarczyk.spokentime.domain;

import com.mlynarczyk.spokentime.ConvertibleToSpokenTime;
import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import lombok.Value;
import org.apache.commons.lang3.Range;


import java.util.*;

@Value
public class Time implements ConvertibleToSpokenTime {

    private static final Range<Integer> HOUR_RANGE = Range.between(0, 12);
    public static final String VALIDATION_MESSAGE = "Hour can not be greater than 12";

    Integer hours;
    Integer minutes;

    public String printSpokenTime(LanguageSpokenTimePrinter printer) {
        Optional<String> validationResult = validateTime();
        if (validationResult.isPresent()) {
            throw new WrongTimeFormatException(validationResult.get());
        }
        return printer.print(this);
    }

    private Optional<String> validateTime() {
        return HOUR_RANGE.isBefore(this.getHours()) ? Optional.of(VALIDATION_MESSAGE) : Optional.empty();
    }

}
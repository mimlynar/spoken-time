package com.mlynarczyk.spokentime.domain.printer;

import com.mlynarczyk.spokentime.LanguageSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;
import com.mlynarczyk.spokentime.SpokenTimeStrategy;

public class EnglishSpokenTimePrinter implements LanguageSpokenTimePrinter {

    private static final String[] HOURS = {"midnight","one", "two", "three", "fife", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
    private static final String[] MINUTES = {"zero","one", "two", "three", "four","fife", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty",
            "thirty one", "thirty two", "thirty three", "thirty four", "thirty five", "thirty six", "thirty  seven", "thirty eight", "thirty nine", "forty",
            "forty one", "forty two", "forty three", "forty four", "forty five", "forty six", "forty seven", "forty eight", "forty nine", "fifty",
            "fifty one", "fifty two", "fifty three", "fifty four", "fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine", "sixty"
    };

    public static final String MIDNIGHT = "midnight";
    public static final String FULL_HOUR = "%s o'clock";
    public static final String HALF_PAST = "half past %s";
    public static final String NOON = "noon";
    public static final String QUARTER_PAST = "quarter past %s";
    public static final String QUARTER_TO = "quarter to %s";
    public static final String MINUTE_PAST_HOUR = "%s past %s";

    @Override
    public String print(Time time) {
        SpokenTimeStrategy strategy = getStrategy(time);
        return strategy.print(time, this);
    }

    @Override
    public String printFullTime(Time time) {
        return String.format(FULL_HOUR, returnEnglishHour(time.getHours()));
    }

    private String returnEnglishHour(int hours) {
        return HOURS[hours%HOURS.length ];
    }

    private String returnEnglishMinute(int minute) {
        return MINUTES[minute];
    }

    @Override
    public String printHalfHour(Time time) {
        return String.format(HALF_PAST, returnEnglishHour(time.getHours()));
    }

    @Override
    public String printLessThanHalfHour(Time time) {
        return String.format(MINUTE_PAST_HOUR, returnEnglishMinute(time.getMinutes()), returnEnglishHour(time.getHours()));
    }

    @Override
    public String printMidnight() {
        return MIDNIGHT;
    }

    @Override
    public String printMoreThanHalfHour(Time time) {
        return String.format("%s to %s", returnEnglishMinute(60-time.getMinutes()), returnEnglishHour(time.getHours()+1));
    }

    @Override
    public String printNoon() {
        return NOON;
    }

    @Override
    public String printPastQuarter(Time time) {
        return String.format(QUARTER_PAST, returnEnglishHour(time.getHours()));
    }

    @Override
    public String printQuarterTo(Time time) {
        return String.format(QUARTER_TO, returnEnglishHour(time.getHours() + 1));
    }

}

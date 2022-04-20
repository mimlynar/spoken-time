package com.mlynarczyk.spokentime.domain;

import com.mlynarczyk.spokentime.domain.printer.EnglishSpokenTimePrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnglishSpokenTimeTest {

    private static final EnglishSpokenTimePrinter ENGLISH_PRINTER = new EnglishSpokenTimePrinter();

    @Test
    public void shouldPrintMidnight() {
        Time time = new Time(0, 0);
        Assertions.assertEquals("midnight", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintOneOClock() {
        Time time = new Time(1, 0);
        Assertions.assertEquals("one o'clock", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintMinutesPastMidnight() {
        Time time = new Time(0, 10);
        Assertions.assertEquals("ten past midnight", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintQuarterPastMidnight() {
        Time time = new Time(0, 15);
        Assertions.assertEquals("quarter past midnight", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintHalfPastMidnight() {
        Time time = new Time(0, 30);
        Assertions.assertEquals("half past midnight", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintQuarterToOne() {
        Time time = new Time(0, 45);
        Assertions.assertEquals("quarter to one", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintTenToToOne() {
        Time time = new Time(0, 50);
        Assertions.assertEquals("ten to one", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldThrowWrongTimeFormatException() {
        Time time = new Time(13, 0);
        Assertions.assertThrows(WrongTimeFormatException.class, () -> time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintMinutesPastOne() {
        Time time = new Time(1, 10);
        Assertions.assertEquals("ten past one", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintQuarterPastOne() {
        Time time = new Time(1, 15);
        Assertions.assertEquals("quarter past one", time.printSpokenTime(ENGLISH_PRINTER));
    }

    @Test
    public void shouldPrintNoon() {
        Time time = new Time(12, 0);
        Assertions.assertEquals("noon", time.printSpokenTime(ENGLISH_PRINTER));
    }

}
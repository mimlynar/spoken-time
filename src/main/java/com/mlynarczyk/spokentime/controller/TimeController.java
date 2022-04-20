package com.mlynarczyk.spokentime.controller;

import com.mlynarczyk.spokentime.domain.printer.EnglishSpokenTimePrinter;
import com.mlynarczyk.spokentime.domain.Time;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
public class TimeController {

    @GetMapping(params = "time")
    public String getSpokenTime(
            @RequestParam
            @DateTimeFormat(pattern = "HH:mm") final LocalTime time) {
        return new Time(time.getHour(), time.getMinute()).printSpokenTime(new EnglishSpokenTimePrinter());
    }
}

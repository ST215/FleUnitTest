package com.stanley.fleunittest;

/**
 * Created by Stanley on 6/20/17.
 */

public class CalendarEvent {

    String eventName;
    long eventStart;
    long eventEnd;

    public CalendarEvent(String eventName, long eventStart, long eventEnd) {
        this.eventName = eventName;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }
}

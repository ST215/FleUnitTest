package com.stanley.fleunittest;

import android.content.Context;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stanley on 6/21/17.
 */
public class calendarUtilsTest {


    @Test
    public void fullDayEventTest() throws Exception {
        CalendarEvent event = new CalendarEvent("Example Event Name",0,0);
        CalendarSettings setting = new CalendarSettings(0,0,0);
        assertEquals(MainActivity.calendarUtils(event, setting, null),"Full Day");
    }

    @Test
    public void halfDayEventOneTest() throws Exception {
        CalendarEvent event = new CalendarEvent("Example Event Name",0,1);
        CalendarSettings setting = new CalendarSettings(0,0,1);
        assertEquals(MainActivity.calendarUtils(event, setting, null),"Half Day");
    }

    @Test
    public void halfDayEventTwoTest() throws Exception {
        CalendarEvent event = new CalendarEvent("Example Event Name",0,1);
        CalendarSettings setting = new CalendarSettings(0,0,1);
        assertEquals(MainActivity.calendarUtils(event, setting, null),"Half Day");
    }

    @Test
    public void CustomEventTest() throws Exception {
        CalendarEvent event = new CalendarEvent("Example Event Name",0,1);
        CalendarSettings setting = new CalendarSettings(0,0,2);
        assertEquals(MainActivity.calendarUtils(event, setting, null),"Custom");
    }

}

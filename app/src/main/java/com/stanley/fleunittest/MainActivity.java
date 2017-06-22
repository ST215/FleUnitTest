package com.stanley.fleunittest;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    SimpleDateFormat fmt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fmt = new SimpleDateFormat("hh:mma");

        final Button button = (Button) findViewById(R.id.btn_addToCalendar);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getEvent();

            }
        });
    }

    private CalendarSettings getSettings() {

        EditText workDayStart = (EditText) findViewById(R.id.et_WorkDayStart);
        EditText workDayEnd = (EditText) findViewById(R.id.et_WorkDayEnd);
        EditText workDayMidday = (EditText) findViewById(R.id.et_WorkDayMiddle);

        try {
            Date workDayStartTime = fmt.parse(workDayStart.getText().toString());

            Date workDayEndTime = fmt.parse(workDayEnd.getText().toString());

            Date workDayMiddayTime = fmt.parse(workDayMidday.getText().toString());

            CalendarSettings settings = new CalendarSettings(workDayStartTime.getTime(),
                    workDayEndTime.getTime(),
                    workDayMiddayTime.getTime());

            return settings;


        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "WorkDay Start time / WorkDay End time / WorkDay Midday improper CORRECT format EXAMPLE: 9:00AM / 9:00PM", Toast.LENGTH_SHORT).show();
        }
        return null;
    }


    private void getEvent() {
        CalendarSettings calendarSettings = getSettings();

        if (calendarSettings != null) {

            EditText eventName = (EditText) findViewById(R.id.et_EventName);
            EditText eventStart = (EditText) findViewById(R.id.et_EventStart);
            EditText eventEnd = (EditText) findViewById(R.id.et_EventEnd);

            try {
                Date eventStartDate = fmt.parse(eventStart.getText().toString());
                Date eventEndDate = fmt.parse(eventEnd.getText().toString());

                CalendarEvent event = new CalendarEvent(eventName.getText().toString(),
                        eventStartDate.getTime(),
                        eventEndDate.getTime());
                calendarUtils(event, calendarSettings, this);

            } catch (ParseException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Event Start time / Event Date time improper CORRECT format EXAMPLE: 9:00AM / 9:00PM", Toast.LENGTH_LONG).show();
            }
        }
    }

    public static String calendarUtils(CalendarEvent event, CalendarSettings settings, Context context) {
        String resultMessage;
        String titleName;
        if (event.eventStart == settings.workDayStart && event.eventEnd == settings.workDayEnd ) {
            resultMessage = "Full Day";
            titleName = event.eventName;
        } else if (event.eventStart == settings.workDayStart && event.eventEnd == settings.workDayMidday ) {
            resultMessage = "Half Day";
            titleName = event.eventName;
        } else if (event.eventStart == settings.workDayMidday && event.eventEnd == settings.workDayEnd ) {
            resultMessage = "Half Day";
            titleName = event.eventName;
        } else {
            resultMessage = "Custom";
            titleName = event.eventName;
        }

        if (context != null) {

            new AlertDialog.Builder(context)
                    .setTitle(titleName + " RESULT")
                    .setMessage(resultMessage)
                    .show();
        }

      return resultMessage;
    };

}

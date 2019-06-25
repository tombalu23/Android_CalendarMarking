package com.blah.project.myapplication123;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity
{

    //public Context context;
    Collection<CalendarDay> dat = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //context = this;

        //dat.add(CalendarDay.from(2019,11,12));
        //decorator dec = new decorator(R.color.colorAccent,dat);
        //dates.add(CalendarDay.from(2019,8,12));

        CalendarDay ob = CalendarDay.from(2019,6,19);

        dat.add(ob);

        ob = CalendarDay.from(2019,6,26);

        dat.add(ob);



        MaterialCalendarView view = findViewById(R.id.cal);

        view.addDecorators(new decorator(R.color.colorAccent,dat,this));

        dat.clear();

        ob = CalendarDay.from(2019,6,20);

        dat.add(ob);

        ob = CalendarDay.from(2019,6,27);

        dat.add(ob);
        view.addDecorators(new decorator1(R.color.colorAccent,dat,this));


    }




}

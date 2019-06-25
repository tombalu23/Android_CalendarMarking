package com.blah.project.myapplication123;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

public class decorator1 implements DayViewDecorator {


    private final int color;
    private final HashSet<CalendarDay> dates;
    Drawable drawable;
    public decorator1(int color, Collection<CalendarDay> dates,Activity context) {
        this.color = color;
        this.dates = new HashSet<>(dates);
        drawable = ContextCompat.getDrawable(context,R.drawable.cal1);



    }



    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {

        // MainActivity ob = new MainActivity();


        view.setSelectionDrawable(drawable);
    }
}

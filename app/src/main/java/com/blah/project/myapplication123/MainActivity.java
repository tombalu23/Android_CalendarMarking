package com.blah.project.myapplication123;

import android.content.Context;
import android.graphics.Color;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
{

    //public Context context;
    Collection<CalendarDay> dat = new ArrayList<>();
    String date;
    ArrayList<JSONObject> jarray = new ArrayList<>();
    JSONArray jsarray=new JSONArray();
    ArrayList<String> dates= new ArrayList<>();

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

        String name = "girish23";



        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://attendance24.herokuapp.com/getn/"+name, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                Log.d("date", String.valueOf(statusCode));
                try {
                    JSONArray jsarray=new JSONArray(new String (response));

                    for(int i=0; i<jsarray.length();i++)
                    {
                        date=jsarray.getJSONObject(i).getString("published");
                        dates.add(date);
                        String [] dateParts= dates.get(i).split("-");
                        int year =Integer.parseInt(dateParts[0]);
                        int month=Integer.parseInt(dateParts[1]);
                        int day=Integer.parseInt(dateParts[2]);
                        CalendarDay D = CalendarDay.from(year, month,day);
                        dat.add(D);
                        MaterialCalendarView view = findViewById(R.id.cal);
                        view.addDecorators(new decorator1(R.color.colorAccent,dat,MainActivity.this));



                    }





                    JSONObject js= new JSONObject(new String(response));
                    date=js.getString("published");


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("date", date);



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("date", "failure");
                Log.d("date", String.valueOf(e));

            }

            @Override
            public void onRetry(int retryNo) {
            }
        });
        




























    }




}

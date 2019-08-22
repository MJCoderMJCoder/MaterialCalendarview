package com.lzf.materialcalendarview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCalendarView widget = findViewById(R.id.calendarView);

        //设置日期范围
        //        widget.setShowOtherDates(MaterialCalendarView.SHOW_ALL);
        Calendar instance = Calendar.getInstance();
        widget.setSelectedDate(instance.getTime());
        Calendar instance1 = Calendar.getInstance();
        instance1.set(instance1.get(Calendar.YEAR), Calendar.JANUARY, 1);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(instance2.get(Calendar.YEAR), Calendar.DECEMBER, 31);
        widget.state().edit()
                //                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                //                .setMinimumDate(CalendarDay.from(2016, 4, 3))
                //                .setMaximumDate(CalendarDay.from(2016, 5, 12))
                //                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .setMinimumDate(instance1.getTime())
                .setMaximumDate(instance2.getTime())
                .commit();


        //增加日期修饰
        Collection<CalendarDay> dates = new ArrayList<CalendarDay>();
        dates.add(CalendarDay.from(2018, 2, 1));
        dates.add(CalendarDay.from(2018, 2, 2));
        dates.add(CalendarDay.from(2018, 2, 3));
        dates.add(CalendarDay.from(2018, 2, 4));
        dates.add(CalendarDay.from(2018, 2, 5));
        dates.add(CalendarDay.from(2018, 2, 6));
        widget.addDecorators(
                //                new MySelectorDecorator(this),
                new HighlightWeekendsDecorator(),
                new OneDayDecorator(),
                new EventDecorator(Color.RED, dates)
        );

        /**
         * 日期禁用：DisableDaysActivity
         * 核心代码是：
         * DayViewFacade view
         * view.setDaysDisabled(true);
         *
         *
         * mcv_showOtherDates：日期范围
         * mcv_firstDayOfWeek：一周的第一天
         * mcv_calendarMode：日历模式
         */
    }
}

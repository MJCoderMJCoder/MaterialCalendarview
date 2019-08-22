package com.lzf.materialcalendarview;

import android.graphics.Typeface;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Date;

/**
 * Created by MJCoder on 2018-01-03.
 * <p>
 * 对选中日期增加指定修饰
 */

public class OneDayDecorator implements DayViewDecorator {
    private CalendarDay date;

    public OneDayDecorator() {
        date = CalendarDay.today();
    }

    /**
     * Determine if a specific day should be decorated
     *
     * @param day {@linkplain CalendarDay} to possibly decorate
     * @return true if this decorator should be applied to the provided day
     */
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        //        return false;
        return date != null && day.equals(date);
    }

    /**
     * Set decoration options onto a facade to be applied to all relevant days
     *
     * @param view View to decorate
     */
    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(3.0f));
    }

    /**
     * 我们正在改变内部，所以一定要回调{@linkplain MaterialCalendarView＃invalidateDecorators（）}
     */
    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}

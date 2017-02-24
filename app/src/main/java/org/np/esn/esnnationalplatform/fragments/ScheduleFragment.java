package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.tibolte.agendacalendarview.AgendaCalendarView;
import com.github.tibolte.agendacalendarview.CalendarPickerController;
import com.github.tibolte.agendacalendarview.models.BaseCalendarEvent;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import com.github.tibolte.agendacalendarview.models.DayItem;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.model.EsnEvent;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class ScheduleFragment extends BaseFragment {

    private static final String REQUEST_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_FORMAT = "HH:mm";

    @Inject
    AppState appState;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
        AgendaCalendarView agendaCalendarView = (AgendaCalendarView)rootView.findViewById(R.id.agenda_calendar_view);
        InjectUtil.component().inject(this);

        Calendar minDate = Calendar.getInstance();
        Calendar maxDate = Calendar.getInstance();

        minDate.set(Calendar.DAY_OF_MONTH, 1);
        maxDate.add(Calendar.MONTH, 1);

        List<CalendarEvent> events = new ArrayList<>();
        try {
            events = buildEventList(appState.getNationalPlatformInfo().getEvents());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        agendaCalendarView.init(events, minDate, maxDate, Locale.getDefault(), new CalendarPickerController() {
            @Override
            public void onDaySelected(DayItem dayItem) {

            }

            @Override
            public void onEventSelected(CalendarEvent event) {

            }

            @Override
            public void onScrollToDate(Calendar calendar) {

            }
        });
        return rootView;
    }

    private List<CalendarEvent> buildEventList(ArrayList<EsnEvent> esnEvents) throws ParseException {
        List<CalendarEvent> eventList = new ArrayList<>();
        for (EsnEvent event: esnEvents) {
            Calendar start = getCalendarFromString(event.getStart());
            Calendar end = getCalendarFromString(event.getEnd());
            if (start.get(Calendar.DAY_OF_MONTH) != end.get(Calendar.DAY_OF_MONTH)) {
                end = getCalendarFromString(event.getStart());
                end.set(Calendar.HOUR_OF_DAY, 23);
                end.set(Calendar.MINUTE, 59);
            }
            BaseCalendarEvent ev = new BaseCalendarEvent
                    (getHourFromCalendar(start) + " - " + event.getName(),
                            event.getDescription(),
                            "",
                    ContextCompat.getColor(getContext(), R.color.theme_primary_dark),
                            start,
                            end,
                            false);
            eventList.add(ev);
        }
        return eventList;
    }

    private Calendar getCalendarFromString(String dateAsString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(REQUEST_DATE_FORMAT, Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(dateAsString));
        return calendar;
    }

    private String getHourFromCalendar (Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        return simpleDateFormat.format(calendar.getTime());
    }

    @Override
    public String getFragmentTag() {
        return "SCHEDULE";
    }
}


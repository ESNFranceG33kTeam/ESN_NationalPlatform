package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.np.esn.esnnationalplatform.R;

public class ScheduleFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
        WebView webView = (WebView) rootView.findViewById(R.id.events_calendar);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://calendar.google.com/calendar/embed?src=spcepnmj0t34lp6ujgp8rdqbus@group.calendar.google.com&ctz=Europe/Brussels&pli=1");
        return rootView;
    }

    @Override
    public String getFragmentTag() {
        return "SCHEDULE";
    }
}


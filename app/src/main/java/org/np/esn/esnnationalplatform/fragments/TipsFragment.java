package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.adapters.TipsAdapter;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.services.events.DataChangedEvent;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import javax.inject.Inject;

public class TipsFragment extends BaseFragment {

    @Inject
    AppState appState;

    private TipsAdapter tipsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tips, container, false);
        InjectUtil.component().inject(this);
        RecyclerView tipsRecyclerView = (RecyclerView) rootView.findViewById(R.id.tips);
        tipsAdapter = new TipsAdapter();
        tipsRecyclerView.setAdapter(tipsAdapter);
        tipsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }

    @Override
    public String getFragmentTag() {
        return "TIPS";
    }

    @Override
    public void onResume() {
        super.onResume();
        appState.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        appState.getBus().unregister(this);
    }

    @Subscribe
    public void onDataChangedEvent(DataChangedEvent event) {
        if (tipsAdapter != null) {
            tipsAdapter.notifyDataSetChanged();
        }
    }
}


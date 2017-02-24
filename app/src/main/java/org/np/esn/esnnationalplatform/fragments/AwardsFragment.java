package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.squareup.otto.Subscribe;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.adapters.AwardsAdapter;
import org.np.esn.esnnationalplatform.adapters.OCMembersAdapter;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.services.events.DataChangedEvent;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import javax.inject.Inject;

public class AwardsFragment extends BaseFragment {

    @Inject
    AppState appState;

    private AwardsAdapter awardsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_awards, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.awards_list);
        InjectUtil.component().inject(this);

        awardsAdapter = new AwardsAdapter();
        recyclerView.setAdapter(awardsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public String getFragmentTag() {
        return "AWARDS";
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
        if (awardsAdapter != null) {
            awardsAdapter.notifyDataSetChanged();
        }
    }
}


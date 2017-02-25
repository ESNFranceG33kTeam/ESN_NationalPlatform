package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import org.np.esn.esnnationalplatform.adapters.AwardsAdapter;
import org.np.esn.esnnationalplatform.adapters.OCMembersAdapter;
import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.services.events.DataChangedEvent;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import javax.inject.Inject;

public class OCMembersFragment extends BaseFragment {

    @Inject
    AppState appState;

    private OCMembersAdapter ocMembersAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_members, container, false);
        InjectUtil.component().inject(this);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.members_list);
        ocMembersAdapter = new OCMembersAdapter();
        recyclerView.setAdapter(ocMembersAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public String getFragmentTag() {
        return "OC_MEMBERS";
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
        if (ocMembersAdapter != null) {
            ocMembersAdapter.notifyDataSetChanged();
        }
    }
}

package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.np.esn.esnnationalplatform.adapters.OCMembersAdapter;
import org.np.esn.esnnationalplatform.R;

public class OCMembersFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_members, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.members_list);
        recyclerView.setAdapter(new OCMembersAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public String getFragmentTag() {
        return "OC_MEMBERS";
    }
}

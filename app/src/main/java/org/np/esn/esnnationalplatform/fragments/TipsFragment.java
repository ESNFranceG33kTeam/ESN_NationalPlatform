package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.adapters.TipsAdapter;

public class TipsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tips, container, false);
        RecyclerView tipsRecyclerView = (RecyclerView) rootView.findViewById(R.id.tips);
        tipsRecyclerView.setAdapter(new TipsAdapter());
        tipsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }

    @Override
    public String getFragmentTag() {
        return "TIPS";
    }
}


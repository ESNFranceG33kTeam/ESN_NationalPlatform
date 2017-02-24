package org.np.esn.esnnationalplatform.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.utils.inject.ForApplication;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import java.util.ArrayList;

import javax.inject.Inject;

public class AwardsAdapter extends RecyclerView.Adapter<AwardsAdapter.AwardViewHolder>{

    ArrayList<String> awards;

    @ForApplication
    @Inject
    Context context;
    @Inject
    AppState appState;

    public AwardsAdapter() {
        InjectUtil.component().inject(this);
        awards = appState.getNationalPlatformInfo().getAwards();
    }

    @Override
    public AwardsAdapter.AwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_awards, parent, false);
        return new AwardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AwardViewHolder holder, int position) {
        holder.setAwards(awards.get(position));
    }

    @Override
    public int getItemCount() {
        return awards.size();
    }

    public class AwardViewHolder extends RecyclerView.ViewHolder {
        TextView label;

        public AwardViewHolder(View v) {
            super(v);
            label =  (TextView) v.findViewById(R.id.award_label);
        }

        public void setAwards(String award) {
            label.setText(award);
        }
    }
}

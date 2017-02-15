package org.np.esn.esnnationalplatform.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.model.Tip;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import java.util.List;

import javax.inject.Inject;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.TipViewHolder> {

    private List<Tip> tipList;

    @Inject
    AppState appState;

    public TipsAdapter() {
        InjectUtil.component().inject(this);
        tipList = appState.getNationalPlatformInfo().getTips();
    }

    @Override
    public TipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_tip, parent, false);
        return new TipViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TipViewHolder holder, int position) {
        Tip tip = tipList.get(position);
        holder.setTip(tip);
    }

    @Override
    public int getItemCount() {
        return tipList.size();
    }

    class TipViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView content;

        public TipViewHolder (View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.tips_title);
            content = (TextView) v.findViewById(R.id.tips_content);
        }

        public void setTip (Tip tip) {
            title.setText(tip.getTitle());
            content.setText(tip.getContent());
        }
    }

}

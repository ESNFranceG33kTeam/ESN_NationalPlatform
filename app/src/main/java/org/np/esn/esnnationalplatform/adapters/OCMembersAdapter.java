package org.np.esn.esnnationalplatform.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.model.Member;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.utils.inject.ForApplication;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import java.util.ArrayList;

import javax.inject.Inject;

public class OCMembersAdapter extends RecyclerView.Adapter<OCMembersAdapter.MemberViewHolder> {

    ArrayList<Member> members;

    @ForApplication
    @Inject
    Context context;
    @Inject
    AppState appState;

    public OCMembersAdapter() {
        InjectUtil.component().inject(this);
        members = appState.getNationalPlatformInfo().getMembers();
    }

    @Override
    public OCMembersAdapter.MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_members, parent, false);
        return new MemberViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OCMembersAdapter.MemberViewHolder holder, int position) {
        Member member = members.get(position);
        holder.setMember(member);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {
        TextView firstname;
        TextView lastname;
        ImageView profileImage;

        public MemberViewHolder(View v) {
            super(v);
            firstname =  (TextView) v.findViewById(R.id.member_firstname);
            lastname =  (TextView) v.findViewById(R.id.member_lastname);
            profileImage = (ImageView) v.findViewById(R.id.member_image);
        }

        public void setMember(Member member) {
            firstname.setText(member.getFirstname());
            lastname.setText(member.getLastname());
            Glide.with(context).load(member.getProfilePicture()).into(profileImage);
        }
    }
}


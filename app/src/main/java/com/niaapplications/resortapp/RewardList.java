package com.niaapplications.resortapp;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
public class RewardList extends ArrayAdapter<Rewards>{
    private Activity context;
    List<Rewards> rewards;

    public RewardList(Activity context, List<Rewards> rewards) {
        super(context, R.layout.rlistlayout, rewards);
        this.context = context;
        this.rewards = rewards;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.rlistlayout, null, true);

        TextView bName = (TextView) listViewItem.findViewById(R.id.businessName);
        TextView rName = (TextView) listViewItem.findViewById(R.id.rewardName);
        TextView points = (TextView) listViewItem.findViewById(R.id.points);

        Rewards rewardObj = rewards.get(position);
        bName.setText(rewardObj.getBusinessName());
        rName.setText(rewardObj.getRewardName());
        points.setText(rewardObj.getPointsNeeded());
        return listViewItem;
    }
}

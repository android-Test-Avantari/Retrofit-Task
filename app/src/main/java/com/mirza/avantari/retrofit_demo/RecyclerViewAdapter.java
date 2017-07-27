package com.mirza.avantari.retrofit_demo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mirza.avantari.retrofit_demo.Model.User;

import java.util.List;

/**
 * Created by AHMED on 27-07-2017.
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserHolder> {
    private static String LOG_TAG = "RecyclerViewAdapter";
    private List<User> userData;

    public static class UserHolder extends RecyclerView.ViewHolder {
        public TextView userId, id, title, body;


        public UserHolder(View itemView) {
            super(itemView);
            userId = (TextView) itemView.findViewById(R.id.userId);
            id = (TextView) itemView.findViewById(R.id.id);
            title = (TextView) itemView.findViewById(R.id.title1);
            body = (TextView) itemView.findViewById(R.id.body);
            Log.i(LOG_TAG, "Adding Listener");
        }

    }


    public RecyclerViewAdapter(List<User> dataset) {
        this.userData = dataset;
    }

    @Override
    public RecyclerViewAdapter.UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        UserHolder UserHolder = new UserHolder(view);
        return UserHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.userId.setText("" + userData.get(position).getUserId());
        holder.id.setText("" + userData.get(position).getId());
        holder.title.setText("" + userData.get(position).getTitle());
        holder.body.setText("" + userData.get(position).getBody());
    }


    @Override
    public int getItemCount() {
        return userData.size();
    }


}

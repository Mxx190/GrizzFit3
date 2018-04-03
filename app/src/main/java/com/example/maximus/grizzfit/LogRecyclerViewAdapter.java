package com.example.maximus.grizzfit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static java.lang.String.valueOf;

public class LogRecyclerViewAdapter extends RecyclerView.Adapter<LogRecyclerViewAdapter.RecyclerViewHolder> {
    private List<FoodLog> logList;

    public LogRecyclerViewAdapter(List<FoodLog> logList) {

        this.logList = logList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        FoodLog log = logList.get(position);
        holder.foodView.setText(log.getmFoodName());
        holder.calView.setText("Calories: " + valueOf(log.getCalories()));
        holder.dateView.setText(log.getDate());
    }

    @Override
    public int getItemCount() {
        return logList.size();
    }

    public void addItems(List<FoodLog> logList) {
        this.logList = logList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView foodView;
        private TextView calView;
        private TextView dateView;

        RecyclerViewHolder(View view) {
            super(view);
            foodView = (TextView) view.findViewById(R.id.foodView);
            calView = (TextView) view.findViewById(R.id.calView);
            dateView = (TextView) view.findViewById(R.id.dateView);
        }
    }
}

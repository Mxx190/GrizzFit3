package com.example.maximus.grizzfit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ViewLog extends Fragment {


    View currentView;
    public Fragment_ViewLog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.fragment_fragment__view_log, container, false);
        //Set up recycle view and attach adapter to it
        RecyclerView recyclerView = currentView.findViewById(R.id.recyclerView);

        LogRecyclerViewAdapter logAdapter = new LogRecyclerViewAdapter(new ArrayList<FoodLog>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(logAdapter);

        //Get view model
        ViewModel viewModel = ViewModelProviders.of(this).get(LogViewModel.class);
        //viewModel.getLogList().observe(Fragment_ViewLog.this, new Observer<List<FoodLog>>);




        final FoodLog logArray[];
        final ListView logListView;
        final TextView labelLogs;

        return currentView;
    }

}

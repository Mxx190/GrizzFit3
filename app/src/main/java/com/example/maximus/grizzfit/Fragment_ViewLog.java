package com.example.maximus.grizzfit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ViewLog extends Fragment {

    FragmentManager fragmentManager = getFragmentManager();


    View currentView;
    public Fragment_ViewLog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        currentView = inflater.inflate(R.layout.fragment_fragment__view_log, container, false);
        final LogDatabase db = LogDatabase.getLogDatabase(this.getActivity().getApplicationContext());
        List<FoodLog> list = db.logDao().getAllNotLive();
        FloatingActionButton fab = currentView.findViewById(R.id.fabAddLog);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)getActivity()).ScreenPicker(new FragmentLog());


                //Toast.makeText(getActivity().getApplicationContext(),"Yeah", Toast.LENGTH_SHORT).show();

            }
        });

        // Inflate the layout for this fragment

        //Set up recycle view and adapter
        RecyclerView recyclerView = currentView.findViewById(R.id.recyclerView);
        final LogRecyclerViewAdapter logAdapter = new LogRecyclerViewAdapter(new ArrayList<FoodLog>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL));

        //Adds the database content to adapter, then attaches it to the view
        logAdapter.addItems(list);
        recyclerView.setAdapter(logAdapter);

        return currentView;
    }

}

package com.example.maximus.grizzfit;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


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
        //ArrayList<String> logList = new ArrayList<>();
        final FoodLog logArray[];
        final ListView logListView;
        final TextView labelLogs;
        labelLogs = currentView.findViewById(R.id.labelLogs);
        //logListView = currentView.findViewById(R.id.lstLog);
        //final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, logList);
        //logListView.setAdapter(adapter);


        final SharedPreferences logs = this.getActivity().getSharedPreferences("logs", 0);
        //Set<String> set = logs.getStringSet("log", null);
        /*String[] fullLog = null;
        for (String string : set){
           fullLog = string.split("/");
        }*/

        String string = logs.getString("logs", null);

        labelLogs.setText(string);

        return currentView;
    }

}

package com.example.maximus.grizzfit;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLog extends Fragment {

    View currentView;


    public FragmentLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.fragment_fragment_log, container, false);


        final SharedPreferences logs = this.getActivity().getSharedPreferences("logs", 0);
        final SharedPreferences.Editor edit = logs.edit();
        final Set<String> set = new HashSet<String>();

        Button btnLog = currentView.findViewById(R.id.btnLog);
        final EditText fieldFood = currentView.findViewById(R.id.fieldFood);
        final EditText fieldCal = currentView.findViewById(R.id.fieldCal);
        //final EditText fieldDate = currentView.findViewById(R.id.fieldDate);
        Button btnDel = currentView.findViewById(R.id.btnDel);


        //Logs the log
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food = fieldFood.getText().toString();
                String calories = fieldCal.getText().toString();
                String date = Calendar.getInstance().getTime().toString();

                //set.add(food + "/" + calories + "/" + date + "-");

                edit.putString("logs", food + "/" + calories + "/" + date + "-");
                //edit.putStringSet("logs", set);
                edit.commit();

                Toast.makeText(getActivity().getApplicationContext(), "Logged", Toast.LENGTH_SHORT).show();
            }
        });



        //Deletes the log

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.clear();
                edit.commit();

                Toast.makeText(getActivity().getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return currentView;
    }


}

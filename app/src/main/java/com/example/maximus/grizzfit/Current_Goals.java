package com.example.maximus.grizzfit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Current_Goals extends Fragment {

    View currentView;
    //private TextView TxtTimerOutput;


    public Current_Goals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        currentView =  inflater.inflate(R.layout.fragment_current__goals, container, false);

        //TextView TxtTimerOutput = currentView.findViewById(R.id.textViewCountDownTimer);

        //GoalCountDownTimer time = new GoalCountDownTimer();

        //System.out.println(time.timeLeftFormatted);

        //TxtTimerOutput.setText();










        return currentView;
    }

}

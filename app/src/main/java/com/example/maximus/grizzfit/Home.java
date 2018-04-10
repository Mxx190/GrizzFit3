package com.example.maximus.grizzfit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    View currentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView tipLab = currentView.findViewById(R.id.tipLabel);

        tipLab.setText(Diet_Tips.getTip());
        return currentView;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

}

package com.example.maximus.grizzfit;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Diet_Tips extends Fragment
{
    View currentView;

    public Diet_Tips()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        currentView = inflater.inflate(R.layout.diet_tips_fragment, container, false);

        final TextView tipLab = currentView.findViewById(R.id.tipLabel);
        Button nextBtn = currentView.findViewById(R.id.nextButton);

        tipLab.setText(getTip());

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipLab.setText(getTip());
            }
        });

        return currentView;
    }

    public static String getTip()
    {
        Random rand = new Random();

        String[] Tips = {"Don't Skip Breakfast",
                "Eat at Regular Times",
                "Eat Plenty of Fruit and Vegetables",
                "Be More Active",
                "Drink Plenty of Water",
                "Eat High Fiber Foods",
                "Read Food Labels",
                "Use a Smaller Plate",
                "Don't Ban Foods",
                "Don't Stock Junk Food",
                "Cut Down on Alcohol",
                "Plan Your Meals"};

        return Tips[rand.nextInt(Tips.length)];
    }

}

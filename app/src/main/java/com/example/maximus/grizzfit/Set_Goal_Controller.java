package com.example.maximus.grizzfit;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class Set_Goal_Controller extends Fragment {

    View currentView;
    private int numberOfSteps;
    private int numberOfDays;
    private int numberOfCalories;

    private TextView countDownTxtView;

    private static long START_TIME_IN_MILLIS = 600000;

    private Button submitStart;

    private CountDownTimer goalCountDownTimer;

    private boolean TimerRunning;

    private long TimeLeftInMillis = START_TIME_IN_MILLIS;



    public Set_Goal_Controller() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.set_goal_fragment3, container, false);

        final ToggleButton exerciseTgbtn = currentView.findViewById(R.id.tgbtnGoalExercise);
        final ToggleButton weightLossTgbtn = currentView.findViewById(R.id.tgbtnGoalWeightLoss);
        final EditText goaledittxt1 = currentView.findViewById(R.id.editTextGoal1);
        final EditText goaledittxt2 = currentView.findViewById(R.id.editTextGoal2);
        final Button buttonSubmit = currentView.findViewById(R.id.buttonGoalSubmit);
        final TextView countDownTxtView = currentView.findViewById(R.id.textViewCountDownTimer);


        goaledittxt1.setVisibility(View.INVISIBLE);
        goaledittxt2.setVisibility(View.INVISIBLE);



        exerciseTgbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    weightLossTgbtn.setVisibility(View.INVISIBLE);

                    goaledittxt1.setVisibility(View.VISIBLE);
                    goaledittxt2.setVisibility(View.VISIBLE);

                    goaledittxt1.setText("Number of Steps");
                    goaledittxt2.setText("Number of days");






                }

                else {

                    weightLossTgbtn.setVisibility(View.VISIBLE);

                    goaledittxt1.setVisibility(View.INVISIBLE);
                    goaledittxt2.setVisibility(View.INVISIBLE);
                    goaledittxt1.setText("");
                    goaledittxt2.setText("");



                }





            }
        });

        weightLossTgbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    exerciseTgbtn.setVisibility(View.INVISIBLE);
                    goaledittxt1.setVisibility(View.VISIBLE);
                    goaledittxt2.setVisibility(View.VISIBLE);
                    goaledittxt1.setText("Number of Calories");
                    goaledittxt2.setText("Number of days");



                }

                else {

                    exerciseTgbtn.setVisibility(View.VISIBLE);
                    goaledittxt1.setVisibility(View.INVISIBLE);
                    goaledittxt2.setVisibility(View.INVISIBLE);
                    goaledittxt1.setText("");
                    goaledittxt2.setText("");




                }



            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if (exerciseTgbtn.isChecked()){

                    numberOfSteps = Integer.parseInt(goaledittxt1.getText().toString());

                }

                else {
                    numberOfCalories = Integer.parseInt(goaledittxt1.getText().toString());

                }

                numberOfDays = Integer.parseInt(goaledittxt2.getText().toString());

                startTimer();

                System.out.println(numberOfCalories);
                System.out.println(numberOfDays);
                System.out.println(numberOfSteps);




                //countDownTxtView.setText(timer.updateCountDownText());


            }
        });


        return currentView;
    }

    public void startTimer(){

        goalCountDownTimer = new CountDownTimer(TimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                TimerRunning = false;

            }
        }.start();
        TimerRunning = true;


    }

    public void pauseTimer(){
        goalCountDownTimer.cancel();
        TimerRunning = false;


    }

    public void resetTimer(){
        TimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();


    }

    public void updateCountDownText(){
        int minutes = (int) (TimeLeftInMillis / 1000) / 60;
        int seconds = (int) (TimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String .format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        System.out.println(timeLeftFormatted);



        //countDownTxtView.setText(timeLeftFormatted);




    }

}

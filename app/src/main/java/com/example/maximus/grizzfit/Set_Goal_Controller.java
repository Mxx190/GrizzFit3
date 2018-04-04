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
    private long numberOfDays;
    private int numberOfCalories;

    private long START_TIME_IN_MILLIS;

    private Button submitStart;

    private CountDownTimer goalCountDownTimer;

    private boolean TimerRunning = false;

    private long TimeLeftInMillis;

    private TextView goalTimer;
    private ToggleButton exerciseTgbtn;
    private ToggleButton weightLossTgbtn;
    private EditText goaledittxt1;
    private EditText goaledittxt2;
    private Button buttonSubmit;
    private TextView goalTitle;
    private TextView directions;
    private TextView goalType;
    private ToggleButton submitToggle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.set_goal_fragment3, container, false);

        exerciseTgbtn = currentView.findViewById(R.id.tgbtnGoalExercise);
        weightLossTgbtn = currentView.findViewById(R.id.tgbtnGoalWeightLoss);
        goaledittxt1 = currentView.findViewById(R.id.editTextGoal1);
        goaledittxt2 = currentView.findViewById(R.id.editTextGoal2);
        goalTitle = currentView.findViewById(R.id.GoalTitle);
        goalTimer = currentView.findViewById(R.id.timerTV);
        directions = currentView.findViewById(R.id.labelDirections);
        goalType = currentView.findViewById(R.id.labelGoalType);

        submitToggle = currentView.findViewById(R.id.submitToggleBtn);



        goaledittxt1.setVisibility(View.INVISIBLE);
        goaledittxt2.setVisibility(View.INVISIBLE);
        goalTitle.setVisibility(View.INVISIBLE);
        goalTimer.setVisibility(View.INVISIBLE);
        submitToggle.setVisibility(View.INVISIBLE);



        exerciseTgbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    weightLossTgbtn.setVisibility(View.INVISIBLE);

                    goaledittxt1.setVisibility(View.VISIBLE);
                    goaledittxt2.setVisibility(View.VISIBLE);


                    goaledittxt1.setText("Number of Steps");
                    goaledittxt2.setText("Number of days");

                    submitToggle.setVisibility(View.VISIBLE);

                }

                else {

                    weightLossTgbtn.setVisibility(View.VISIBLE);

                    goaledittxt1.setVisibility(View.INVISIBLE);
                    goaledittxt2.setVisibility(View.INVISIBLE);
                    goaledittxt1.setText("");
                    goaledittxt2.setText("");

                    submitToggle.setVisibility(View.INVISIBLE);


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
                    goaledittxt2.setText("Number of Days");
                    submitToggle.setVisibility(View.VISIBLE);

                }

                else {

                    exerciseTgbtn.setVisibility(View.VISIBLE);
                    goaledittxt1.setVisibility(View.INVISIBLE);
                    goaledittxt2.setVisibility(View.INVISIBLE);
                    goaledittxt1.setText("");
                    goaledittxt2.setText("");
                    submitToggle.setVisibility(View.INVISIBLE);


                }

            }
        });



        submitToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    if (exerciseTgbtn.isChecked()){

                        numberOfSteps = Integer.parseInt(goaledittxt1.getText().toString());

                        goalTitle.setText("Step goal of " + numberOfSteps);

                    }

                    else {
                        numberOfCalories = Integer.parseInt(goaledittxt1.getText().toString());

                        goalTitle.setText("Calorie goal of " + numberOfCalories);

                    }

                    updateNumberOfDays();

                    exerciseTgbtn.setVisibility(View.INVISIBLE);
                    weightLossTgbtn.setVisibility(View.INVISIBLE);
                    goaledittxt1.setVisibility(View.INVISIBLE);
                    goaledittxt2.setVisibility(View.INVISIBLE);
                    goalType.setVisibility(View.INVISIBLE);
                    directions.setVisibility(View.INVISIBLE);

                    startTimer();

                    goalTitle.setVisibility(View.VISIBLE);
                    goalTimer.setVisibility(View.VISIBLE);


                } else {

                    exerciseTgbtn.setVisibility(View.VISIBLE);
                    weightLossTgbtn.setVisibility(View.VISIBLE);
                    goaledittxt1.setVisibility(View.VISIBLE);
                    goaledittxt2.setVisibility(View.VISIBLE);
                    goalType.setVisibility(View.VISIBLE);
                    directions.setVisibility(View.VISIBLE);

                    goalTitle.setVisibility(View.INVISIBLE);
                    goalTimer.setVisibility(View.INVISIBLE);
                    pauseTimer();
                    resetTimer();

                    //TimerRunning = false;

                    //MainActivity remove = new MainActivity();

                    //remove.removeGoalAdded();



                    System.out.println("Time left in millis = " + TimeLeftInMillis);
                    System.out.println("Starttime left in millis = " + START_TIME_IN_MILLIS);


                    exerciseTgbtn.setChecked(false);
                    weightLossTgbtn.setChecked(false);


                }

            }
        });




        return currentView;
    }

    public void updateNumberOfDays(){

        numberOfDays = Integer.parseInt(goaledittxt2.getText().toString());

        START_TIME_IN_MILLIS = numberOfDays * 86400000;

        TimeLeftInMillis = START_TIME_IN_MILLIS;

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
        int days = (int) (TimeLeftInMillis / (1000*60*60*24));
        int hours   = (int) ((TimeLeftInMillis / (1000*60*60)) % 24);
        int minutes = (int) ((TimeLeftInMillis / (1000*60)) % 60);
        int seconds = (int) (TimeLeftInMillis / 1000) % 60 ;

        String timeLeftFormatted = String .format(Locale.getDefault(),"%02d:%02d:%02d:%02d", days, hours, minutes, seconds);

        goalTimer.setText(timeLeftFormatted);
        System.out.println(timeLeftFormatted);
    }

}

package com.example.maximus.grizzfit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Set_Goal_Controller extends Fragment {

    View currentView;
    private int numberOfSteps;
    private int numberOfDays;
    private int numberOfCalories;
    public TextView goalTimer;
    private ToggleButton exerciseTgbtn;
    private ToggleButton weightLossTgbtn;
    private EditText goaledittxt1;
    private EditText goaledittxt2;
    private Button buttonSubmit;
    private TextView goalTitle;
    private TextView directions;
    private TextView goalType;
    private ToggleButton submitToggle;
    private String Test1 = "";



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
            Count_Down_Timer cTimer = new Count_Down_Timer(goalTimer);
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    if (goaledittxt1.getText().toString().isEmpty()){

                        goaledittxt1.setError(Html.fromHtml("<font color='#ffffff'>Field cannot be empty</font>"));

                        goaledittxt1.requestFocus();

                        submitToggle.setChecked(false);

                        return;

                    }

                    Test1 = goaledittxt1.getText().toString();

                    if (!Test1.matches("^[1-9]\\d*$")){

                        goaledittxt1.setError(Html.fromHtml("<font color='#ffffff'>Value must be number</font>"));

                        goaledittxt1.requestFocus();

                        submitToggle.setChecked(false);

                        Test1 = "";

                        return;

                    }

                    if (goaledittxt2.getText().toString().isEmpty()){

                        goaledittxt2.setError(Html.fromHtml("<font color='#ffffff'>Field cannot be empty</font>"));

                        goaledittxt2.requestFocus();

                        submitToggle.setChecked(false);

                        return;

                    }

                    Test1 = goaledittxt2.getText().toString();

                    if (!Test1.matches("^[1-9]\\d*$")){

                        goaledittxt2.setError(Html.fromHtml("<font color='#ffffff'>Value must be number</font>"));

                        goaledittxt2.requestFocus();

                        submitToggle.setChecked(false);

                        return;

                    }

                    if (exerciseTgbtn.isChecked()){

                        numberOfSteps = Integer.parseInt(goaledittxt1.getText().toString());

                        goalTitle.setText("Step goal of " + numberOfSteps);

                    }

                    else {
                        numberOfCalories = Integer.parseInt(goaledittxt1.getText().toString());

                        goalTitle.setText("Calorie goal of " + numberOfCalories);

                    }


                    numberOfDays = Integer.parseInt(goaledittxt2.getText().toString());

                    cTimer.updateNumberOfDays(numberOfDays);

                    exerciseTgbtn.setVisibility(View.INVISIBLE);
                    weightLossTgbtn.setVisibility(View.INVISIBLE);
                    goaledittxt1.setVisibility(View.INVISIBLE);
                    goaledittxt2.setVisibility(View.INVISIBLE);
                    goalType.setVisibility(View.INVISIBLE);
                    directions.setVisibility(View.INVISIBLE);

                    cTimer.startTimer();

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
                    cTimer.pauseTimer();
                    cTimer.resetTimer();


                    exerciseTgbtn.setChecked(false);
                    weightLossTgbtn.setChecked(false);


                }

            }
        });






        return currentView;
    }





}

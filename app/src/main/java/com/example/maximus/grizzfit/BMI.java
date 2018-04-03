package com.example.maximus.grizzfit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BMI extends Fragment {

    View currentView;

    public BMI() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.bmi_fragment1, container, false);

        //Aligning xml elements with the java elements
        Button btnCalculate =  currentView.findViewById(R.id.btnCalculateBMI);
        final EditText fieldWeight = currentView.findViewById(R.id.fieldWeight);
        final EditText fieldHeight = currentView.findViewById(R.id.fieldHeight);
        final TextView labelOutput = currentView.findViewById(R.id.labelBMIOutput);

        //Calculating the BMI
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float weight = 0;
                float height = 0;
                float bmi = 0;

                //Calculates BMI after checking to make sure the information is valid.

                if ((fieldWeight.getText().toString().equals("")  || (fieldWeight.getText().toString().equals("0")))) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter in a proper Weight", Toast.LENGTH_SHORT).show();
                }
                else if ((fieldHeight.getText().toString().equals("")  || (fieldHeight.getText().toString().equals("0")))) {
                    Toast.makeText(getActivity().getApplicationContext(),"Please enter in a proper Height", Toast.LENGTH_SHORT).show();
                }
                else {
                    weight = Integer.parseInt(fieldWeight.getText().toString());
                    height = Integer.parseInt(fieldHeight.getText().toString());
                    bmi = (703 * (weight / (height * height)));
                }
                labelOutput.setText(String.valueOf(bmi));

            }
        });

        return currentView;




    }

}



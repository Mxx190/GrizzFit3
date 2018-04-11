package com.example.maximus.grizzfit;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BMI extends Fragment {

    View currentView;
    Integer ft = 12345;
    Integer in = 12345;

    public BMI() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.bmi_fragment1, container, false);

        //Aligning xml elements with the java elements
        final Button btnCalculate =  currentView.findViewById(R.id.btnCalculateBMI);
        final EditText fieldWeight = currentView.findViewById(R.id.fieldWeight);
        final Spinner ftSpin = currentView.findViewById(R.id.ftSpinner);
        final Spinner inSpin = currentView.findViewById(R.id.inSpinner);
        final TextView labelOutput = currentView.findViewById(R.id.labelBMIOutput);

        List<Integer> ftChoice = new ArrayList<Integer>();
        ftChoice.add(2);
        ftChoice.add(3);
        ftChoice.add(4);
        ftChoice.add(5);
        ftChoice.add(6);
        ftChoice.add(7);
        ArrayAdapter<Integer> ftspinnerArrayAdapter = new ArrayAdapter<Integer> (getActivity(), android.R.layout.simple_spinner_item, ftChoice);
        ftspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ftSpin.setAdapter(ftspinnerArrayAdapter);

        ftSpin.setOnItemSelectedListener(new ftSpinnerActivity());

        List<Integer> inChoice = new ArrayList<Integer>();
        inChoice.add(0);
        inChoice.add(1);
        inChoice.add(2);
        inChoice.add(3);
        inChoice.add(4);
        inChoice.add(5);
        inChoice.add(6);
        inChoice.add(7);
        inChoice.add(8);
        inChoice.add(9);
        inChoice.add(10);
        inChoice.add(11);
        ArrayAdapter<Integer> inspinnerArrayAdapter = new ArrayAdapter<Integer> (getActivity(), android.R.layout.simple_spinner_item, inChoice);
        inspinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inSpin.setAdapter(inspinnerArrayAdapter);

        inSpin.setOnItemSelectedListener(new inSpinnerActivity());

        //Calculating the BMI
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float weight = 0;
                float height = 0;
                float bmi = 0;

                height = calcHeight(ft, in);


                //Calculates BMI after checking to make sure the information is valid.

                if ((fieldWeight.getText().toString().equals("")  || (fieldWeight.getText().toString().equals("0")))) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter in a proper Weight", Toast.LENGTH_SHORT).show();
                }
                else {
                    weight = Integer.parseInt(fieldWeight.getText().toString());
                    bmi = calcBMI(height, weight);
                }

                labelOutput.setText(String.valueOf(bmi));

            }
        });

        return currentView;




    }

    public class ftSpinnerActivity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            String num = parent.getItemAtPosition(pos).toString();
            ft = Integer.parseInt(num);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public class inSpinnerActivity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            String num = parent.getItemAtPosition(pos).toString();
            in = Integer.parseInt(num);

        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public static int calcHeight(Integer f, Integer i)
    {
        //calculates height
        f = f * 12;
        return f + i;
    }

    public static float calcBMI(float h, float w)
    {
            return (703 * (w / (h * h)));
    }

}

package com.example.maximus.grizzfit;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLog extends Fragment {

    View currentView;
    FragmentManager fragmentManager = getFragmentManager();

    public FragmentLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.fragment_fragment_log, container, false);

        final LogDatabase db = LogDatabase.getLogDatabase(this.getActivity().getApplicationContext());

        Button btnLog = currentView.findViewById(R.id.btnLog);
        final EditText fieldFood = currentView.findViewById(R.id.fieldFood);
        final EditText fieldCal = currentView.findViewById(R.id.fieldCal);

        Button btnDel = currentView.findViewById(R.id.btnDel);


        //Checks the field. Then inserts a log into database if valid
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");

                if(fieldFood.getText().toString().equals("") ){
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter a food", Toast.LENGTH_SHORT).show();

                }
                else if((fieldCal.getText().toString().equals(""))){
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter calories", Toast.LENGTH_SHORT).show();
                }
                else{
                    String food = fieldFood.getText().toString();
                    Integer cal = Integer.parseInt(fieldCal.getText().toString());
                    String date = dFormat.format(new Date());
                    createLog(db, food, cal, date);
                    Toast.makeText(getActivity().getApplicationContext(), "Logged", Toast.LENGTH_SHORT).show();

                    fragmentManager.beginTransaction().replace(R.id.fram, new Fragment_ViewLog()).commit();
                }
            }
        });

        //Deletes everything in the datbase
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.logDao().deleteItAll();

                Toast.makeText(getActivity().getApplicationContext(), "Deleted all logs", Toast.LENGTH_SHORT).show();

                fragmentManager.beginTransaction().replace(R.id.fram, new Fragment_ViewLog()).commit();
            }
        });

        return currentView;
    }

    //Sends log to database
    private static FoodLog addLog(final LogDatabase db, FoodLog log) {
        db.logDao().insertAll(log);
        return log;
    }

    //assembles the log
    private static void createLog(LogDatabase db, String food, int cal, String date) {
        FoodLog log = new FoodLog();
        log.setmFoodName(food);
        log.setCalories(cal);
        log.setDate(date);
        addLog(db, log);
    }


}

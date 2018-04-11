package com.example.maximus.grizzfit;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.hardware.SensorEvent;



/**
 * A simple {@link Fragment} subclass.
 */
public class Steps_Counter extends Fragment implements SensorEventListener {

    View currentView;

    TextView tv_steps;

    SensorManager sensorManager;

    boolean running = false;

    public Steps_Counter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.steps_counter_fragment4, container, false);

        tv_steps = currentView.findViewById(R.id.tv_steps);

        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);




        return currentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this.getContext(), "Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        running = false;
        //sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (running) {
            tv_steps.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}

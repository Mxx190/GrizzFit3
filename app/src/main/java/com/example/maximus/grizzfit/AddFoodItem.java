package com.example.maximus.grizzfit;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFoodItem extends Fragment {

    View currentView;


    public AddFoodItem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.activity_add_food_item, container, false);

        final SharedPreferences prefs = this.getActivity().getSharedPreferences("FoodItems", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        final Gson gson = new Gson();

        Button createFoodBtn = (Button) currentView.findViewById(R.id.createFoodBtn);
        createFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText) currentView.findViewById(R.id.nameText);
                EditText caloriesText = (EditText) currentView.findViewById(R.id.caloriesText);
                EditText fatText = (EditText) currentView.findViewById(R.id.fatText);
                EditText cholesterolText = (EditText) currentView.findViewById(R.id.cholesterolText);
                EditText sodiumText = (EditText) currentView.findViewById(R.id.sodiumText);
                EditText carbohydratesText = (EditText) currentView.findViewById(R.id.carbohydratesText);
                EditText proteinText = (EditText) currentView.findViewById(R.id.proteinText);

                //get values
                String foodName = nameText.getText().toString();
                int calories = Integer.parseInt(caloriesText.getText().toString());
                int fat = Integer.parseInt(fatText.getText().toString());
                int cholesterol = Integer.parseInt(cholesterolText.getText().toString());
                int sodium = Integer.parseInt(sodiumText.getText().toString());
                int carbs = Integer.parseInt(carbohydratesText.getText().toString());
                int protein = Integer.parseInt(proteinText.getText().toString());

                FoodItem food = new FoodItem(foodName, calories, fat, cholesterol, sodium, carbs, protein);
                ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
                //get existing list of foods from shared preferences
                if (prefs.getString("FoodItems", null) != null) {
                    String json = prefs.getString("FoodItems", null);
                    Type type = new TypeToken<ArrayList<FoodItem>>(){}.getType();
                    foodItems = gson.fromJson(json, type);
                }
                //add new item to foodItems
                foodItems.add(food);

                String newJson = gson.toJson(foodItems);
                editor.putString("FoodItems", newJson);
                editor.apply();

                //notify user that item has been added and clear fields
                CharSequence text = "Food Created: " + foodName;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), text, duration);
                toast.show();

                nameText.setText("");
                caloriesText.setText("");
                fatText.setText("");
                cholesterolText.setText("");
                sodiumText.setText("");
                carbohydratesText.setText("");
                proteinText.setText("");
            }});
        return currentView;
    }
}

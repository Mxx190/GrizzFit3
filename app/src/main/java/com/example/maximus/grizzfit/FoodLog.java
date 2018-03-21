package com.example.maximus.grizzfit;

import java.util.Date;

/**
 * Created by Zach on 3/20/2018.
 */

public class FoodLog {

    private String mFoodName;
    private int calories;
    private String date;

    public String getmFoodName() {
        return mFoodName;
    }

    public void setmFoodName(String mFoodName) {
        this.mFoodName = mFoodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.example.maximus.grizzfit;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Zach on 3/20/2018.
 */

@Entity
public class FoodLog {

    @PrimaryKey(autoGenerate = true)
    private int foodID;
    @ColumnInfo(name = "food_name")
    private String mFoodName;
    @ColumnInfo(name = "calories")
    private int calories;
    @ColumnInfo(name = "date")
    private String date;

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

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

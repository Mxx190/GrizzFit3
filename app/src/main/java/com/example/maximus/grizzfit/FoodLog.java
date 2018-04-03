package com.example.maximus.grizzfit;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Zach on 3/20/2018.
 */

@Entity(tableName = "FoodLog")
public class FoodLog {

    @PrimaryKey(autoGenerate = true)
    public int foodID = 0;
    @ColumnInfo(name = "food_name")
    public String mFoodName = "food";
    @ColumnInfo(name = "calories")
    public int calories = 0;
    @ColumnInfo(name = "date")
    public String date = "today";

    /*@Ignore
    public FoodLog(){

    }
    public FoodLog(String sFoodName, int sCalories, String sDate){
        this.mFoodName = sFoodName;
        this.calories = sCalories;
        this.date = sDate;
    }*/

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

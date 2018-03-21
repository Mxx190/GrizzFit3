package com.example.maximus.grizzfit;

/**
 * Created by Nate on 3/20/2018.
 */

public class FoodItem {
    private String foodName;
    private int calories;
    private int fat;
    private int cholesterol;
    private int sodium;
    private int carbs;
    private int protein;

    public FoodItem(String foodName, int calories, int fat, int cholesterol, int sodium, int carbs, int protein) {
        setFoodName(foodName);
        setCalories(calories);
        setFat(fat);
        setCholesterol(cholesterol);
        setSodium(sodium);
        setCarbs(carbs);
        setProtein(protein);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "foodName='" + foodName + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", cholesterol=" + cholesterol +
                ", sodium=" + sodium +
                ", carbs=" + carbs +
                ", protein=" + protein +
                '}';
    }
}

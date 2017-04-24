package com.example.windows10.gymbuff;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FoodDiary extends AppCompatActivity {
    Button submitButton;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_diary);
        submitButton = (Button)findViewById(R.id.submit_Button);
        submitButton.setOnClickListener(insertFood);
        db =  new Database(this);
    }
    private View.OnClickListener insertFood = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText meal_Name = (EditText)findViewById(R.id.meal_Name);
            EditText Calorie_count = (EditText)findViewById(R.id.Calorie_Count);
            EditText Protein_Count = (EditText)findViewById(R.id.Protein_Count);
            EditText Carb_Count = (EditText)findViewById(R.id.Carb_Count);
            EditText Fat_count = (EditText)findViewById(R.id.Fat_Count);
            String mealName = meal_Name.getText().toString();
            float calories = Float.parseFloat(Calorie_count.getText().toString());
            float protein = Float.parseFloat(Protein_Count.getText().toString());
            float carbs = Float.parseFloat(Carb_Count.getText().toString());
            float fats = Float.parseFloat(Fat_count.getText().toString());
            String query = "INSERT into foodDiary(food_name,proteins,calories,carbs,fats) values ("+mealName+String.valueOf(calories)+String.valueOf(protein)+String.valueOf(carbs)+String.valueOf(fats)+")";
            db.test();
            Intent menu = new Intent(FoodDiary.this,Menu.class);
            startActivity(menu);
        }
    };
}

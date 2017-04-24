package com.example.windows10.gymbuff;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheckFood extends AppCompatActivity {
    Database db;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_food);

        text = (TextView)findViewById(R.id.CheckSQL);
        db = new Database(this);
       // String query = "Select meal_name from FoodDiary;";
        Cursor c = db.returnQuery();
        if(c.getCount()==0)
        text.setText("Empty");
        else if (c.getCount() != 0)
            text.setText("Not Empty");
    }
}

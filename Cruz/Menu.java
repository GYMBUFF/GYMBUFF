package com.example.windows10.gymbuff;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button food,camera,check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        food = (Button)findViewById(R.id.Food);
        camera = (Button)findViewById(R.id.cameraButton);
        check = (Button)findViewById(R.id.CheckFood);

        camera.setOnClickListener(launch_Camera);
        food.setOnClickListener(launch_Diary);
        check.setOnClickListener(launch_Food);

        if(!hasCamera()){
            camera.setEnabled(false);
        }
    }
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
    private View.OnClickListener launch_Camera = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent camera = new Intent(Menu.this,Camera.class);
            startActivity(camera);
        }
    };
    private View.OnClickListener launch_Diary = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent diary = new Intent(Menu.this,FoodDiary.class);
            startActivity(diary);
        }
    };
    private  View.OnClickListener launch_Food = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent food = new Intent(Menu.this,CheckFood.class);
            startActivity(food);
        }
    };
}

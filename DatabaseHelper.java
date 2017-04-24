package com.example.windows10.gymbuff;

/**
 * Created by Windows 10 on 24/04/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.id.primary;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Gymbuff";

    private static final int DATABASE_VERSION = 2;

    // Database creation sql statement
    private static final String DATABASE_CREATE_USERS = ("CREATE TABLE IF NOT EXISTS users(username VARCHAR, password VARCHAR);");
    private static final String DATABASE_CREATE_WORKOUTS = ("CREATE TABLE IF NOT EXISTS workouts(workout_id INT, workout_name VARCHAR, mon_sesh INT, tues_sesh INT, weds_sesh INT, thurs_sesh INT, fri_sesh INT, sat_sesh INT, sun_sesh INT, level VARCHAR, description VARCHAR);");
    private static final String DATABASE_CREATE_SESSIONS = ("CREATE TABLE IF NOT EXISTS sessions(session_id INT, day VARCHAR, ex1 INT, ex2 INT, ex3 INT, ex4 INT, ex5 INT, ex6 INT, ex7 INT, ex8 INT, ex9 INT, ex10 INT, ex11 INT, ex12 INT, ex13 INT, ex14 INT, ex15 INT, ex16 INT, ex17 INT, ex18 INT, ex19 INT, ex20 INT);");
    private static final String DATABASE_CREATE_EXERCISES = ("CREATE TABLE IF NOT EXISTS exercises(ex_id INT, ex_name VARCHAR, area VARCHAR);");
    private static final String DATABASE_CREATE_FOODDIARY = ("CREATE TABLE IF NOT EXISTS foodDiary(meal_name VARCHAR,calorie_count FLOAT,protein_count FLOAT,carb_count FLOAT,fat_count FLOAT);");

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_USERS);
        database.execSQL(DATABASE_CREATE_WORKOUTS);
        database.execSQL(DATABASE_CREATE_SESSIONS);
        database.execSQL(DATABASE_CREATE_EXERCISES);
        database.execSQL(DATABASE_CREATE_FOODDIARY);
        database.execSQL("INSERT INTO exercises VALUES(1, 'Bench Press', 'chest'), (2, 'Squat', 'legs'), (3, 'Deadlift', 'back'), (4, 'Dumbbell Curls', 'arms'), (5, 'Pull-ups', 'back'), " +
                "(6, 'Dumbbell Shoulder Press', 'shoulders'), (7, 'Cable Cross', 'chest'), (8, 'Cable Rows', 'back'), (9, 'Dumbbell Lunges', 'legs'), (10, 'Russian Twists', 'core');");
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from " + oldVersion +" to "+newVersion);
        database.execSQL("DROP TABLE IF EXISTS users");
        onCreate(database);
    }
}

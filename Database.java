package com.example.windows10.gymbuff;

/**
 * Created by Windows 10 on 24/04/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;


import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Brian on 25/03/2017.
 */

public class Database{

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public final static String USERS_TABLE="users"; //table names

    public final static String USER_NAME="username";
    public final static String PASSWORD="password";

    public Database(Context context){
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long insertQuery(String id, String name){
        ContentValues values = new ContentValues();
        values.put(USER_NAME, id);
        values.put(PASSWORD, name);
        return database.insert(USERS_TABLE, null, values);
    }

    public Cursor runQuery(String query, String[] args) {
        Cursor mCursor = database.rawQuery(query, args);
        if (mCursor.moveToFirst()) {
            mCursor.moveToFirst();
        }
        return mCursor; // returns array of data
    }

    public void execSQL(String s) {
        database.execSQL(s);
    }
    public Cursor returnQuery(){
        Cursor c = database.rawQuery("Select * from foodDiary",null);
        while (c.moveToFirst()){
            String column1 = c.getString(0);
            Float column2 = c.getFloat(1);
            Float column3 = c.getFloat(2);
            Float column4 = c.getFloat(3);
            Float column5 = c.getFloat(4);
        }
        c.close();
        return c;
    }
    public void test(){
        database.execSQL("INSERT INTO foodDiary(meal_name,calorie_count,protein_count,carb_count,fat_count) VALUES(rice,1,1,1,1)",null);
    }

}


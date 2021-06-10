package com.example.quanlyktx.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanlyktx.Dao.StudentDao;
import com.example.quanlyktx.Dao.UserDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase database = getWritableDatabase();
    public DatabaseHelper(@Nullable Context context ) {
        super( context, "qlktx2.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Student(fullname text ,date text,adress text,phone text primary key)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + StudentDao.TABLE_STUDENT);
    }
}

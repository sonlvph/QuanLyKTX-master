package com.example.quanlyktx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    public void sinhVien(View view){
        Intent intent=new Intent(MainActivity.this, ListStudentActivity.class);
        startActivity(intent);
    }
    public void tang(View view){
        Intent intent=new Intent(MainActivity.this, TangActivity.class);
        startActivity(intent);
    }
    public void phong(View view){
        Intent intent=new Intent(MainActivity.this, RoomActivity.class);
        startActivity(intent);
    }
//    public void thongKe(View view){
//        Intent intent=new Intent(MainActivity.this, ListStudentActivity.class);
//        startActivity(intent);
//    }
}
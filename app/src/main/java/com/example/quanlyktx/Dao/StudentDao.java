package com.example.quanlyktx.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyktx.Database.DatabaseHelper;
import com.example.quanlyktx.Model.Student;


import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_STUDENT="Student";


    public StudentDao(Context context){
        dbHelper = new DatabaseHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    //them
    public int insertStudent(Student student){
        ContentValues values = new ContentValues(); //Đưa dữ liệu vào bảng
        values.put( "fullname",student.getFullname() );
        values.put( "date",student.getDate() );
        values.put( "adress",student.getAdress() );
        values.put( "phone",student.getPhone() );

        try{
            if (db.insert( TABLE_STUDENT,null,values )<0){
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    public List<Student> getAllStudent(){
        List<Student> listHospital = new ArrayList<>();
        Cursor cursor = db.query( TABLE_STUDENT,null,null,null,null,null,null );
        cursor.moveToFirst();  //Di chuyển con trỏ đến hàng đầu tiên
        while (cursor.isAfterLast() == false){//nếu không phải bảng ghi cuối cùng
            Student student = new Student();
            student.setFullname( cursor.getString( 0 ) );
            student.setDate( cursor.getString( 1 ) );
            student.setAdress( cursor.getString( 2 ) );
            student.setPhone( cursor.getString( 3) );
            listHospital.add( student ); //day thong tin vao mang
            cursor.moveToNext(); //di chuyen con tro den hangn tiep theo
        }
        cursor.close();
        return listHospital;
    }

    //xoa

    public int DeleteStudent(String ten){
        int kq = db.delete( TABLE_STUDENT,"fullname = ?",new String[]{ten} );
        if (kq==0){
            return -1;
        }
        return 1;
    }

    //Sua
    public int UpdateStudent(Student student){
        ContentValues values = new ContentValues();
        values.put( "fullname",student.getFullname() );
        values.put( "date",student.getDate() );
        values.put( "adress",student.getAdress() );


        int kq = db.update( TABLE_STUDENT,values,"fullname = ?",new String[]{student.getFullname()} );
        try {
            if (kq == 0){
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    public int updateStudent(Student student){
        ContentValues values = new ContentValues();
        values.put( "fullname",student.getFullname() );
        values.put( "date",student.getDate() );
        values.put( "adress",student.getAdress() );
        values.put( "phone",student.getPhone() );


        int kq =db.update(TABLE_STUDENT, values,"phone=?",new String[]{String.valueOf(student.getPhone())});
        try {
            if (kq ==0) {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}

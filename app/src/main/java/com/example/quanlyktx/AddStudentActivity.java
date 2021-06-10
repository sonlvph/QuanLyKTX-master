package com.example.quanlyktx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlyktx.Adapter.StudentAdapter;
import com.example.quanlyktx.Dao.StudentDao;
import com.example.quanlyktx.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class AddStudentActivity extends AppCompatActivity {
        EditText edtFullname,edtDate,edtDress,edtPhone;
    StudentDao studentDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_student );
        edtFullname = findViewById( R.id.edtFullname );
        edtDate = findViewById( R.id.edtDate );
        edtDress = findViewById( R.id.edtAdress );
        edtPhone = findViewById( R.id.edtPhone );




    }

       public void addStudent(View view){
           studentDao=new StudentDao(AddStudentActivity.this);
           Student student=new Student(edtFullname.getText().toString(), edtDate.getText().toString(),
                   edtDress.getText().toString(), edtPhone.getText().toString());

           try {
               if (studentDao.insertStudent(student) > 0) {
                   Toast.makeText(getApplicationContext(), "Them Thanh Cong", Toast.LENGTH_LONG).show();
                   Intent intent=new Intent(this, ListStudentActivity.class);
                   startActivity(intent);



               } else {
                   Toast.makeText(getApplicationContext(), "Them That Bai", Toast.LENGTH_LONG).show();
               }
           } catch (Exception e) {
               Log.e("Loi", e.toString());
           }
       }
       public void sohw(View view){
           Intent intent=new Intent(AddStudentActivity.this, ListStudentActivity.class);
           startActivity(intent);
       }
    public void ListSV(View view){
        Intent intent=new Intent(this, ListStudentActivity.class);
        startActivity(intent);
    }
}
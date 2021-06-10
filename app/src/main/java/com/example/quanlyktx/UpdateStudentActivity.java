package com.example.quanlyktx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlyktx.Dao.StudentDao;
import com.example.quanlyktx.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class UpdateStudentActivity extends AppCompatActivity {
    EditText edtUpdateFullname,edtUpdateDate,edtUpdateDress;
    String ten,tuoi,quequan;
    StudentDao studentDao;
    int i;
    public static List<Student> dsStudent=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_student );
        edtUpdateFullname = findViewById( R.id.edtUpdateFullname );
        edtUpdateDate = findViewById( R.id.edtUpdateDate );
        edtUpdateDress = findViewById( R.id.edtUpdateAdress );

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra( "bun" );

         ten = bundle.getString( "fullname" );
         tuoi = bundle.getString( "date" );
        quequan = bundle.getString( "adress" );
        i = bundle.getInt( "id" );
        edtUpdateFullname.setText( ten );
        edtUpdateDate.setText( tuoi );
        edtUpdateDress.setText( quequan );
    }

    public void updateStudent(View view){
        studentDao = new StudentDao( UpdateStudentActivity.this );
        Student student =  dsStudent.get(i);
        student.setFullname(edtUpdateFullname.getText().toString());
        student.setDate(edtUpdateDate.getText().toString());
        student.setAdress(edtUpdateDress.getText().toString());
        int kq = studentDao.updateStudent(student);
        if(kq<=0)
        {
            Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_LONG).show();
        }

    }
}
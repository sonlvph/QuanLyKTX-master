package com.example.quanlyktx;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlyktx.Adapter.StudentAdapter;
import com.example.quanlyktx.Dao.StudentDao;
import com.example.quanlyktx.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListStudentActivity extends AppCompatActivity {
    Intent intent;
    public static List<Student> dsStudent=new ArrayList<>();
    ListView lvStudent;
    StudentDao studentDao;
    StudentAdapter adapter;
    EditText edtSuaFullname,edtSuaDate,edtSuaAdress,edtSuaSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_student );
        lvStudent = findViewById( R.id.lvStudent );

        studentDao = new StudentDao(ListStudentActivity.this);
        dsStudent  =studentDao.getAllStudent();
        adapter = new StudentAdapter(dsStudent,this);
        lvStudent.setAdapter(adapter);



        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {
                LayoutInflater inflater = getLayoutInflater();
                final View layout = inflater.inflate(R.layout.dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(ListStudentActivity.this);
                builder.setTitle("Sửa thông tin sinh viên");
                builder.setView(layout);
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edtSuaFullname = layout.findViewById(R.id.txt_suaFullname);
                        edtSuaDate = layout.findViewById(R.id.txt_suaDate);
                        edtSuaAdress = layout.findViewById(R.id.txt_suaAdress);
                        edtSuaSDT = layout.findViewById(R.id.txt_suaSDT);
                        studentDao = new StudentDao(ListStudentActivity.this);
                        Student student = dsStudent.get(i);
                        student.setFullname(edtSuaFullname.getText().toString());
                        student.setDate(edtSuaDate.getText().toString());
                        student.setAdress(edtSuaAdress.getText().toString());
                        student.setPhone(edtSuaSDT.getText().toString());
                        studentDao.updateStudent(student);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(ListStudentActivity.this, "Update thành công", Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void addStudent(View view) {
        Intent intent=new Intent(this, AddStudentActivity.class);
        startActivity(intent);
    }
}
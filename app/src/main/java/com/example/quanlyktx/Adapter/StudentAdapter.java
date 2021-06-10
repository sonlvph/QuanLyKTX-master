package com.example.quanlyktx.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlyktx.Dao.StudentDao;
import com.example.quanlyktx.Model.Student;
import com.example.quanlyktx.R;
import com.example.quanlyktx.UpdateStudentActivity;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Student> arrStudent;
    Context context;
    public LayoutInflater inflater;
    StudentDao studentDao;

    public StudentAdapter(List<Student> arrStudent, Context context) {
        this.arrStudent=arrStudent;
        this.context=context;
        this.studentDao= new StudentDao( context );
        this.inflater=(LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }
    @Override
    public int getCount() {
        return arrStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHoder hoder;
        if (view==null){
            view=inflater.inflate( R.layout.row,null );
            hoder = new ViewHoder();
            hoder.tvFullname = (TextView) view.findViewById( R.id.tvTenSV );
            hoder.tvDate = (TextView) view.findViewById( R.id.tvNamSinh );
            hoder.tvAdress =(TextView) view.findViewById( R.id.tvQueQuan );
            hoder.tvSDT =(TextView) view.findViewById( R.id.tvSDT );

            hoder.ivUpdate =(ImageView)view.findViewById( R.id.ivUpdate );

            hoder.ivDelete=(ImageView)view.findViewById( R.id.ivDelete );
            //xoa
            hoder.ivDelete.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Bạn có chắc chắn muốn xóa ?");
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
                            String a = arrStudent.get( i ).getFullname();
                            studentDao.DeleteStudent( a );//xoa trong database
                            Student student = arrStudent.get( i );
                            arrStudent.remove( student );//xoa trong list

                            notifyDataSetChanged();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            } );


            view.setTag( hoder );
        }else{
            hoder=(ViewHoder)view.getTag();
        }



        hoder.ivUpdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateStudentActivity.class);

                Bundle bundle  = new Bundle();
                bundle.putString("fullname",arrStudent.get(i).getFullname());
                bundle.putString("date",arrStudent.get(i).getDate());
                bundle.putString("adress",arrStudent.get(i).getAdress());
                bundle.putString("sdt",arrStudent.get(i).getAdress());

                bundle.putInt( "id",i );


                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        } );

        Student student = arrStudent.get( i );
        hoder.tvFullname.setText( student.getFullname() );
        hoder.tvDate.setText( student.getDate() );
        hoder.tvAdress.setText( student.getAdress() );
        hoder.tvSDT.setText( student.getPhone() );

        return view;
    }
    public static class ViewHoder{
        ImageView ivDelete,ivUpdate;
        TextView tvFullname,tvDate,tvAdress,tvSDT;

    }

}

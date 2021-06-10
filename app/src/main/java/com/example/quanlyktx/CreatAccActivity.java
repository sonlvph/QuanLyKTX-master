package com.example.quanlyktx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreatAccActivity extends AppCompatActivity {
    Button btnCreatAcc;
    EditText edtUser,edtPass,edtCofPass,edtFullname;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_creat_acc );
        edtUser = findViewById( R.id.editUserRegister );
        edtPass = findViewById( R.id.editPassRegister );
        edtFullname = findViewById(R.id.edtFullnameRegister);
        edtCofPass = findViewById( R.id.editCofPassRegister );
        btnCreatAcc = findViewById( R.id.btnCreatAcc );

         fAuth= FirebaseAuth.getInstance();
         btnCreatAcc.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String Name = edtFullname.getText().toString();
                 String pass = edtPass.getText().toString();
                 String confPass = edtCofPass.getText().toString();
                 String fullname = edtUser.getText().toString();



                 //check rong
                 if (Name.isEmpty()){
                     edtFullname.setError( "Khong duoc de trong Fullname" );
                     return;
                 } else if (!pass.equals( confPass )){
                     edtCofPass.setError( " Confpass khong trung nhau" );
                     return;
                 }else if (pass.isEmpty()){
                     edtPass.setError( "Khong duoc de trong Pass" );
                     return;
                 }
                 else if (confPass.isEmpty()){
                     edtCofPass.setError( "Khong duoc de trong Confpass" );
                     return;
                 }

                 else if (fullname.isEmpty()){
                     edtUser.setError( "Khong duoc de trong Email" );
                     return;}


              fAuth.createUserWithEmailAndPassword( fullname,pass ).addOnSuccessListener( new OnSuccessListener<AuthResult>() {
                  @Override
                  public void onSuccess(AuthResult authResult) {
                      Toast.makeText( CreatAccActivity.this,"Thanh cong",Toast.LENGTH_LONG ).show();
                      startActivity( new Intent(getApplicationContext(),SignInActivity.class) );
                      finish();
                  }
              } ).addOnFailureListener( new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      Toast.makeText( CreatAccActivity.this,e.getMessage(),Toast.LENGTH_LONG ).show();
                  }
              } );
             }
         } );

    }
}
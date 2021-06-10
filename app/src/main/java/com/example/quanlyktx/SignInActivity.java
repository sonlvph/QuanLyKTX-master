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

public class SignInActivity extends AppCompatActivity {
    Button btncreate, btnlogin;
    EditText edtUser,edtPass;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_in );
        btncreate = findViewById(R.id.btnCreat);
        btnlogin = findViewById(R.id.btnSignIn);
        edtUser = findViewById(R.id.editUser);
        edtPass = findViewById(R.id.editPass);

        firebaseAuth = FirebaseAuth.getInstance();
        btnlogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (edtUser.getText().toString().isEmpty()){
                      edtUser.setError( "khong duoc de trong email" );
                      return;
                 }
                 if (edtPass.getText().toString().isEmpty()){
                     edtPass.setError( "Khong duoc de trong pass" );
                     return;
                 }
               firebaseAuth.signInWithEmailAndPassword( edtUser.getText().toString(),edtPass.getText().toString() ).addOnSuccessListener( new OnSuccessListener<AuthResult>() {
                   @Override
                   public void onSuccess(AuthResult authResult) {
                       Toast.makeText( SignInActivity.this,"Dang nhap thanh cong",Toast.LENGTH_LONG ).show();
                       startActivity( new Intent(getApplicationContext(),MainActivity.class) );
                     finish();
                   }
               } ).addOnFailureListener( new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText( SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT ).show();
                   }
               } );
            }
        } );
    }

    public void btncreate(View view) {
        Intent intent = new Intent(this,CreatAccActivity.class);
        startActivity(intent);

    }
}
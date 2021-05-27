package com.example.btl_music4b.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btl_music4b.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText LoginPhone,LoginPassword;
    Button LoginButton;
    String Phone,Password;
    String userPassword;

    ProgressDialog LoadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoadingBar = new ProgressDialog(this);
        LoginPhone = (EditText)findViewById(R.id.login_phone);
        LoginPassword = (EditText)findViewById(R.id.login_password);
        LoginButton= (Button)findViewById(R.id.login_btn);

        LoadingBar.setTitle("Login Account");
        LoadingBar.setMessage("Please wait , we are checking your credentials in our database");
        LoadingBar.setCanceledOnTouchOutside(false);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone = LoginPhone.getText().toString();
                Password = LoginPassword.getText().toString();
                LoginAccount(Phone,Password);
            }
        });
    }
    private void LoginAccount(final String phone , String password){
        // now check edittext is empty or not
        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this,"Please enter your phone number ...",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Password)){
            Toast.makeText(this,"Please enter your password",Toast.LENGTH_SHORT).show();
        }
        else{
            LoadingBar.show();
            final DatabaseReference mRef;
            mRef = FirebaseDatabase.getInstance().getReference();
            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // now if edit text are not empty then we check that the Phone that the user entered os exits in
                    // our database or not
                    //if it us exist in our database then we retrive password is "UserPassword" and then
                    //match that password with the password that user entered in edittext
                    //if it is match then we redirect user to home activity
                    if (snapshot.child("Users").child(phone).exists()){
                        //if exitst retrive password from database
                        userPassword = snapshot.child("Users").child(Phone).child("password").getValue().toString();
                        if (Password.equals(userPassword)){
                            LoadingBar.dismiss();
                            //then go to home activity // make new activity to navigate
                            Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(i);

                            //so if user exist with the number that they enter and with correct password then user will redirect to
                            //music lib activity
                            //let run and check it
                        }
                        else{
                            //if password is not correct
                            LoadingBar.dismiss();
                            Toast.makeText(LoginActivity.this,"Please enter valid password ...",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        //User not exist
                        LoadingBar.dismiss();
                        Toast.makeText(LoginActivity.this,"User with this number does not exist ...",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}
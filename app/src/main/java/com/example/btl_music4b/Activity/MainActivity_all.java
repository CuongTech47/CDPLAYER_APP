package com.example.btl_music4b.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.btl_music4b.R;

public class MainActivity_all extends AppCompatActivity {

    Button Register ;
    TextView Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_all);


        Register = (Button)findViewById(R.id.home_register_button);
        Login = (TextView) findViewById(R.id.home_login_textview);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity_all.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity_all.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
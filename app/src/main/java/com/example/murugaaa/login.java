package com.example.murugaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username,password;

    TextView logtv,head;
    Button loginBtn;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        DB=new DBHelper(this);
        loginBtn=(Button) findViewById(R.id.loginButton);
        logtv=(TextView)findViewById(R.id.signinText);
        head=(TextView)findViewById(R.id.loginText);

        head.setTypeface(null, Typeface.BOLD_ITALIC);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(login.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkUsernamePassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(login.this, "login succesfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(login.this,"Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        logtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),signupActivity.class);
                startActivity(intent);
            }
        });
    }

}

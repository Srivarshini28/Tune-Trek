package com.example.murugaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signupActivity extends AppCompatActivity {
    EditText regUser, regPass, regChkpass;

    TextView regtv;
    Button regBtn;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        regBtn = (Button) findViewById(R.id.rButton);
        regUser = (EditText) findViewById(R.id.rusername);
        regPass = (EditText) findViewById(R.id.rpassword);
        regChkpass = (EditText) findViewById(R.id.rpassword1);
        regtv=(TextView)findViewById(R.id.signupText);
        DB=new DBHelper(this);

        regtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=regUser.getText().toString();
                String pass= regPass.getText().toString();
                String chkpass= regChkpass.getText().toString();

                if(user.equals("")||pass.equals("")||chkpass.equals(""))
                    Toast.makeText(signupActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(chkpass)) {
                        Boolean checkuser = DB.checkUsername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(signupActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(signupActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(signupActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(signupActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
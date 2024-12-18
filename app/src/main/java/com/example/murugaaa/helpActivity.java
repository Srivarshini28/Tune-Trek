package com.example.murugaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class helpActivity extends AppCompatActivity {

    String strEmail, strSubject, strText;
    EditText etEmailSubject, etEmailText;
    TextView etEmailApp;
    Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        etEmailApp = findViewById(R.id.et_email_app);
        etEmailSubject = findViewById(R.id.et_email_subject);
        etEmailText = findViewById(R.id.et_email_text);
        btnSendEmail = findViewById(R.id.btn_send_email);

        // Set default email address
        etEmailApp.setText("tunetrek78@gmail.com"); // Replace with your default email address

        btnSendEmail.setOnClickListener(view -> {

            strEmail = etEmailApp.getText().toString();
            strSubject = etEmailSubject.getText().toString();
            strText = etEmailText.getText().toString();

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

            emailIntent.setData(Uri.parse("mailto:"));

            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{strEmail});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, strSubject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, strText);

            startActivity(Intent.createChooser(emailIntent, "Send Email"));

        });
    }
}

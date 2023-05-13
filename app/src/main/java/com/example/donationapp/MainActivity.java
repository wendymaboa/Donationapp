package com.example.donationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;




import com.google.android.material.button.MaterialButton;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mylinks=findViewById(R.id.mylink);
        TextView number=(TextView) findViewById(R.id.numbers);
        TextView username=(TextView) findViewById(R.id.username);
        TextView password=(TextView) findViewById(R.id.password);

        String text="Don't have an account? Create one.";
        SpannableString ss= new SpannableString(text);

        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //i can make the new page for signing up here.
                Toast.makeText(MainActivity.this, "Create one.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpan1,23,33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mylinks.setText(ss);
        mylinks.setMovementMethod(LinkMovementMethod.getInstance());

        MaterialButton loginbtn=(MaterialButton) findViewById(R.id.loginbtn);
        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number.getText().toString().equals("00000")&&username.getText().toString().equals("admin")&& password.getText().toString().equals("admin")){
                    //IF THE LOGINS ARE CORRECT
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();


                }else
                    //IF THE LOGINS ARE INCORRECT
                    Toast.makeText(MainActivity.this,"LOGIN UNSUCCESSFUL",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
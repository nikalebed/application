package com.veronikalebedyuk.dialogforbetter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.veronikalebedyuk.dialogforbetter.classes.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StartActivity extends AppCompatActivity {

    DatabaseReference myRef;
    User newUser;
    String userID;
    EditText name;
    EditText email;
    Button btn;
    DateFormat dateFormat =new SimpleDateFormat("dd_MM_YY_hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        name = findViewById(R.id.entername);
        email = findViewById(R.id.enteremail);
        email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        btn = findViewById(R.id.btnContinue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(StartActivity.this, "пожалуйста, заполните все поля", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, 0, 0);
                if (email.getText().toString().trim().equals("") || email.getText().toString().trim().equals(""))t.show();
                else {
                    if(validEmail(email)) {
                        userID = dateFormat.format(Calendar.getInstance().getTime()) + name.getText().toString();
                        myRef = FirebaseDatabase.getInstance().getReference("Users");
                        newUser = new User(name.getText().toString(), email.getText().toString());
                        myRef.child(userID).setValue(new User(name.getText().toString(), email.getText().toString()));
                        Intent i = new Intent(StartActivity.this, PhisiologyActivity.class);
                        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                        prefs.edit().putString("user", userID).apply();
                        prefs.edit().putString("email", email.getText().toString()).apply();
                        prefs.edit().putString("name", name.getText().toString()).apply();
                        startActivity(i);
                    }
                    else{
                        t = Toast.makeText(StartActivity.this, "введите корректный EMAIL", Toast.LENGTH_LONG);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();
                    }
                }
            }
        });
    }
    public boolean validEmail(EditText et){
         String email = et.getText().toString();
         if(Patterns.EMAIL_ADDRESS.matcher(email).matches())return true;
         else return false;
    }
}
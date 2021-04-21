package com.example.prev_ques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    String sid, pass, c5;
    public static String id = "sid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.sid);
        et2 = findViewById(R.id.password);
    }

    public void Login(View view) {
        DBHelper mydb = new DBHelper(this);
        sid = et1.getText().toString();
        pass = et2.getText().toString();
        c5 = pass.substring(4, 5);
        if(c5.contains("s")){
            mydb.insertUser(sid);
            Intent i = new Intent(MainActivity.this, NextActivity.class);
            i.putExtra(id, sid);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Login failed! Enter your password again!", Toast.LENGTH_SHORT).show();
        }
    }
}
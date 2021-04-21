package com.example.prev_ques;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    String sid;
    Fragment myfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent i = getIntent();
        sid = i.getStringExtra(MainActivity.id);
    }

    public void bmi(View view){
        Bundle b = new Bundle();
        b.putString("sid", sid);
        myfragment = new bmi();
        myfragment.setArguments(b);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.myFragment, myfragment);
        ft.commit();
    }

    public void celcius(View view) {
        Bundle b = new Bundle();
        b.putString("sid", sid);
        myfragment = new celcius();
        myfragment.setArguments(b);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.myFragment, myfragment);
        ft.commit();
    }

    public void fahrenheit(View view) {
        Bundle b = new Bundle();
        b.putString("sid", sid);
        myfragment = new fahrenheit();
        myfragment.setArguments(b);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.myFragment, myfragment);
        ft.commit();
    }

    public void getUser(View view) {
        DBHelper mydb = new DBHelper(this);
        Cursor res = mydb.getUser();
        if(res.getCount() == 0){
            showMessage("error", "nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append(res.getString(0)+"\n");
        }
        showMessage("All user", buffer.toString());
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
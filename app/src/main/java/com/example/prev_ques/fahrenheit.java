package com.example.prev_ques;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fahrenheit extends Fragment {

    EditText et1;
    TextView tv1, tv2;
    Button btn;
    float f, c, result;
    String sid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fahrenheit, container, false);

        et1 = v.findViewById(R.id.et1);
        btn = v.findViewById(R.id.ftc);
        tv1 = v.findViewById(R.id.tv1);
        tv2 = v.findViewById(R.id.tv2);

        Bundle b = getArguments();
        sid = b.getString("sid");
        tv1.setText(sid);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Float.valueOf(et1.getText().toString());
                f = (c * 9/5) + 32;
                tv2.setText(""+f);
            }
        });

        return v;
    }
}
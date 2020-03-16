package com.kiran.calculateagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView current_TV, result_TV;
    EditText birth_TV;
    Calendar calendar;

    int year, month, day;

    int endyear, endmonth, endday;

    int resyear, resmonth, resday;
    DatePickerDialog dialog;

    DatePicker datepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();
        button = findViewById(R.id.button);
        current_TV = findViewById(R.id.current_TV);
        result_TV = findViewById(R.id.result_TV);
        birth_TV = findViewById(R.id.birth_TV);

        button.setOnClickListener(this);
        datepicker = findViewById(R.id.datepicker);

    }

    @Override
    public void onClick(View v) {
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        month=month+1;

        day = calendar.get(Calendar.HOUR_OF_DAY);
        String str = new StringBuilder().append(day).append("/").append(month).append("/").append(year).toString();
        current_TV.setText(str);
        //Birth date

        //String dob=birth_TV.getText().toString().trim();
        endyear = datepicker.getYear();
        endmonth = datepicker.getMonth();
        endday = datepicker.getDayOfMonth();

        String dob = new StringBuilder().append(endday).append("/").append(endmonth).append("/").append(endyear).toString();
        birth_TV.setText(dob);

        resyear = year - endyear;
        if (endmonth >= month) {
            year = year - 1;
            month = month + 12;
        } else {
            resmonth = month - endmonth;
        }

        if (endday > day) {
            day = day + 30;
            month = month - 1;
        } else{
            resday = day - endday;
    }


    String result = new StringBuilder().append(resday).append("/").append(resmonth).append("/").append(resyear).toString();
        result_TV.setText(result);




    }
}

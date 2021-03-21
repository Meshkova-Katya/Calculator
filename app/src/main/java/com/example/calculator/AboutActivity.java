package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import static com.example.calculator.MainActivity.amount;

public class AboutActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    static EditText editText3;
    int temp1;
    int temp2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        editText3 = findViewById(R.id.editText3);

        temp1 = getIntent().getIntExtra("editText1", 0);
        temp2 = getIntent().getIntExtra("editText2", 0);

        choiceCondition();

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("temp1") && savedInstanceState.containsKey("temp2")) {
            temp1 = savedInstanceState.getInt("temp1");
            temp2 = savedInstanceState.getInt("temp2");
            choiceCondition();
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("temp1", temp1);
        outState.putInt("temp2", temp2);
    }

    @SuppressLint("SetTextI18n")
    public void choiceCondition() {
        if (temp2 < 0) {
            editText3.setText(temp1 + "+" + "(" + temp2 + ")" + " " + "=" + amount);
        } else {
            editText3.setText(temp1 + "+" + temp2 + " " + "=" + amount);
        }
        if (temp1 == 0 && temp2 == 0) {
            editText3.setText("Некорректный ввод");
        }

    }

}
package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static int amount = 0;
    static boolean isbool = false;

    String str1 = "Первое слагаемое";
    String str2 = "Второе слагаемое";

    EditText editText1;
    EditText editText2;

    int temp1, temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(String.valueOf(str1));
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(String.valueOf(str2));


    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        errorHandling();
        intent.putExtra("editText1", temp1);
        intent.putExtra("editText2", temp2);
        startActivity(intent);
    }

    /**
     * Метод, проверяющий число на валидность
     */
    void errorHandling() {
        try {
            parses();
            isbool = true;
        } catch (Exception e) {
            isbool = false;
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод с переменным числом параметров
     */
    void parses() {
        // Считываю с editText1 и editText2 текстовые значения
        String s1 = editText1.getText().toString();
        String s2 = editText2.getText().toString();
        // Преобразуем текстовые переменные в числовые значения
        temp1 = Integer.parseInt(s1);
        temp2 = Integer.parseInt(s2);
        amount = temp1 + temp2;
    }
}
package com.example.menufun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivityTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startEditActivity();
    }

    void startEditActivity() {
        Intent intent = new Intent(this, EditItemActivity.class);
        startActivity(intent);
    }
}

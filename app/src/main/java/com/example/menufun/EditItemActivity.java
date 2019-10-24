package com.example.menufun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class EditItemActivity extends AppCompatActivity {
    final static String TAG = "MainActivityTag: Edit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Log.d(TAG, "onCreate: ");
    }
}

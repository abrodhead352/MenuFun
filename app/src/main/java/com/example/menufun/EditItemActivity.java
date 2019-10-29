package com.example.menufun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class EditItemActivity extends AppCompatActivity {
    final static String TAG = "MainActivityTag: Edit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Log.d(TAG, "onCreate: ");

        //add the "up" button, arrow back to a previous activity
        //two options for what the previous activity could be
        //1) parent activity (defined in androidManifest.xml
        //2) last activity under this one on the call stack

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

package com.example.menufun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivityTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //task: create a listview, set the content view to be the listview
        //add a list of items
        //create an arrayAdapter
        //make sure your items show up
        //startEditActivity();
        final ListView listView = new ListView(this);
        final List<String> list = new ArrayList<>();
        list.add("Pumpkins");
        list.add("Ghosts");
        list.add("Skeletons");
        list.add("Candy");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, list);
        listView.setAdapter(adapter);
        setContentView(listView);
        //contextual action mode (CAM)
        //can select multiple items to perform a bulk change (delete, move, etc emails)
        //a menu shows up over the app bar
        //set listview to support multiple selections
        //modal -- user HAS TO interact with it, a dialog, etc
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        //set the multichoice listener
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                int numChecked = listView.getCheckedItemCount();
                mode.setTitle(numChecked + " selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.contextual_action_mode_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                //not needed for pa7
                return false;
            }

            //activates when a user clicks a CAM menu item
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.deleteMenuItem:
                        //hint for PA7 -- check id's
                        String temp = listView.getCheckedItemPositions().toString();
                        mode.finish();
                        return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                //not needed for pa7
            }
        });
    }

    void startEditActivity() {
        Intent intent = new Intent(this, EditItemActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //get a reference to the menu inflator
        MenuInflater menuInflater = getMenuInflater();
        //inflate our menu
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    //override a callback that executes whenever an options menu action is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.addMenuItem:
                startEditActivity();
                return true; //we have consumed/handled this click event
            case R.id.preferencesMenuItem:
                Log.d(TAG, "onOptionsItemSelected: prefs");
                return true;
            case R.id.aboutMenuItem:
                Log.d(TAG, "onOptionsItemSelected: about");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

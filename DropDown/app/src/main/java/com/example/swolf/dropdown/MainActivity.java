package com.example.swolf.dropdown;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity implements
        ActionBar.OnNavigationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setListNavigationCallbacks(
                new ArrayAdapter<String>(
                    MainActivity.this, android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                        new String[] {"First", "Second", "Third"}),
                this);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Fragment fragment = new DummyFragment();
        Bundle args = new Bundle();
        args.putInt(DummyFragment.BUNDLE_KEY, itemPosition + 1);
        fragment.setArguments(args);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("hello")) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt("hello")
            );
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt("hello", getActionBar().getSelectedNavigationIndex());
    }
}

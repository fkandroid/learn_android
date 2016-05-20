package com.example.swolf.actionbartab;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    private static final String SELECTED_ITEM = "selected_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar mybar = getSupportActionBar();
        mybar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mybar.addTab(mybar.newTab().setText("第一页").setTabListener(this));
        mybar.addTab(mybar.newTab().setText("第二页").setTabListener(this));
        mybar.addTab(mybar.newTab().setText("第三页").setTabListener(this));

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(SELECTED_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(SELECTED_ITEM));  //restore时获得哪个tab selected.
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // save data to indicate which tab is selected.
        outState.putInt(SELECTED_ITEM, getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public void onTabUnselected(
            ActionBar.Tab tab,
            android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabSelected (
            ActionBar.Tab tab,
            android.support.v4.app.FragmentTransaction fragmentTransaction){
        Fragment fragment = new DummyFragment();
        Bundle args = new Bundle();
        args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
        fragment.setArguments(args);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    @Override
    public void onTabReselected (
            ActionBar.Tab tab,
            android.support.v4.app.FragmentTransaction fragmentTransaction){
        System.out.println("Here");
    }


}

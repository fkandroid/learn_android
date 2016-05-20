package com.example.swolf.pageview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by swolf on 16/4/7.
 */
public class DummyFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        Bundle args = getArguments();
        textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
        textView.setTextSize(50);

        return textView;
    }
}

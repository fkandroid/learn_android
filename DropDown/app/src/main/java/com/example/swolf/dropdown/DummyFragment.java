package com.example.swolf.dropdown;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by swolf on 16/4/7.
 */
public class DummyFragment extends Fragment {

    public static String BUNDLE_KEY = "bundle_key";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT)
        );
        Bundle bundle = getArguments();
        int position = bundle.getInt(BUNDLE_KEY);
        textView.setText(Integer.toString(position));
        textView.setTextColor(Color.RED);
        textView.setTextSize(50);

        return textView;
    }
}

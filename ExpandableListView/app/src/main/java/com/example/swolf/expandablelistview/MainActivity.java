package com.example.swolf.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logos = new int[] {
                    R.drawable.p,
                    R.drawable.t,
                    R.drawable.z
            };

            private String[] planeTypes = new String[] {
                    "军用飞机",
                    "民用飞机",
                    "其他飞机"
            };

            private String[][] planes = new String[][] {
                    {"战斗机", "歼击机", "侦察机", "运输机", "预警机", "加油机"},
                    {"大型客机", "中型客机", "小型客机"},
                    {"民用直升机", "武装直升机"},
            };

            @Override
            public int getGroupCount() {
                return planeTypes.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return planes[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return planeTypes[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return planes[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout layout = new LinearLayout(MainActivity.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);

                ImageView headmap = new ImageView(MainActivity.this);
                headmap.setImageResource(logos[groupPosition]);

                TextView text = new TextView(MainActivity.this);
                text.setText(getGroup(groupPosition).toString());

                layout.addView(headmap);
                layout.addView(text);

                return layout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView text = new TextView(MainActivity.this);
                AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                text.setLayoutParams(params);
                text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                text.setPadding(36, 0, 0, 0);
                text.setTextSize(20);
                text.setText(getChild(groupPosition, childPosition).toString());
                return text;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {

                return true;
            }
        };

        ExpandableListView expandListView = (ExpandableListView) findViewById(R.id.expandlist);
        expandListView.setAdapter(adapter);
    }
}

package com.example.swolf.activityforresulttest;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by swolf on 16/5/8.
 */
public class SelectCity extends ExpandableListActivity {

    String[] provinces = new String[]{
            "黑龙江",
            "吉林",
            "辽宁"
    };

    String[][] cities = new String[][] {
            {"哈尔滨", "齐齐哈尔", "牡丹江", "佳木斯", "绥化"},
            {"长春", "吉林", "四平"},
            {"沈阳", "大连", "锦州", "葫芦岛", "辽阳", "鞍山"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExpandableListAdapter adapter = new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return provinces.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return provinces[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
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
                return false;
            }

            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView textView = new TextView(SelectCity.this);
                textView.setLayoutParams(lp);
                textView.setPadding(36, 0, 0, 0);
                return textView;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                TextView text = getTextView();
                text.setText(getGroup(groupPosition).toString());
                text.setTextSize(36);
                text.setTextColor(Color.RED);
                text.setTypeface(null, Typeface.BOLD);
                return text;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView text = getTextView();
                text.setText(getChild(groupPosition, childPosition).toString());
                text.setTextSize(24);
                return text;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        setListAdapter(adapter);

        getExpandableListView().setOnChildClickListener(
                new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v,
                            int groupPosition, int childPosition, long id) {
                        Intent intent = new Intent();
                        intent.putExtra("city", cities[groupPosition][childPosition]);
                        SelectCity.this.setResult(0, intent);
                        SelectCity.this.finish();
                        return false;
                    }
                }
        );
    }
}

package com.example.swolf.fragmenttest;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.swolf.model.BookContent;

/**
 * Created by swolf on 16/5/17.
 */
public class BookListFragment extends ListFragment {
    private Callbacks mCallbacks;

    public  interface Callbacks {
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                BookContent.books
        ));
    }

    
    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);

        if (! (context instanceof Callbacks)) {
            throw new IllegalStateException("BookListFragment 所在的Activity必须实现Callbacks接口!");
        }

        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity().
                getApplicationContext(), "position: " + position, Toast.LENGTH_SHORT).show();
        mCallbacks.onItemSelected(position);
    }


}

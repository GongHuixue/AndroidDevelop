package com.example.huixuegong.androiddevelop.fragment.bookfragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by huixue.gong on 2018/2/6.
 */

public class BookListFragment extends ListFragment {
    private FragmentCallback fragmentCallback;

    public interface FragmentCallback {
        public void onItemClicked(Integer id);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(!(activity instanceof FragmentCallback)) {
            throw new IllegalStateException("the activity much impletes the fragmentcallbcak");
        }

        fragmentCallback = (FragmentCallback) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                BookContent.ITEMS));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentCallback = null;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        fragmentCallback.onItemClicked(BookContent.ITEMS.get(position).id);
    }
}

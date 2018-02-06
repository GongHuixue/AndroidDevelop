package com.example.huixuegong.androiddevelop.fragment.bookfragment;

import android.app.Activity;
import android.os.Bundle;

import com.example.huixuegong.androiddevelop.R;

public class BookFragmentActivity extends Activity implements BookListFragment.FragmentCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_fragment);
    }

    @Override
    public void onItemClicked(Integer id) {
        Bundle arg = new Bundle();
        arg.putInt(BookDetailFragment.ITEM_ID, id);

        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(arg);
        getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
    }
}

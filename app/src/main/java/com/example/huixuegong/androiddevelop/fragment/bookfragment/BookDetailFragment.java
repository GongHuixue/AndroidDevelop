package com.example.huixuegong.androiddevelop.fragment.bookfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

/**
 * Created by huixue.gong on 2018/2/6.
 */

public class BookDetailFragment extends Fragment {
    public final static String ITEM_ID = "book_id";
    BookContent.Book book;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(ITEM_ID)) {
            book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_detail_fragment, container, false);

        if(book != null) {
            ((TextView)rootView.findViewById(R.id.book_title)).setText(book.title);
            ((TextView)rootView.findViewById(R.id.book_detail)).setText(book.detail);
        }
        return rootView;
    }
}

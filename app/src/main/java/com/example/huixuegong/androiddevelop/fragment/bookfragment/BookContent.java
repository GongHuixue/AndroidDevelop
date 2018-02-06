package com.example.huixuegong.androiddevelop.fragment.bookfragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huixue.gong on 2018/2/6.
 */

public class BookContent {
    public static class Book {
        public Integer id;
        public String title;
        public String detail;

        public Book(Integer id, String title, String detail) {
            this.id = id;
            this.title = title;
            this.detail = detail;
        }
        @Override
        public String toString() {
            return title;
        }
    }

    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();

    static {
        addItem(new Book(1, "第一行代码", "作者：郭霖；Android 入门推荐"));
        addItem(new Book(2,"Android 开发艺术探索", "作者：任玉刚；Android 进阶"));
        addItem(new Book(3,"Android 源码设计模式解析","作者：何宏辉；Android 进阶"));
    }
    public static void addItem(Book book) {
        ITEMS.add(book);
        ITEM_MAP.put(book.id, book);
    }
}

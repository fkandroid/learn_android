package com.example.swolf.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by swolf on 16/5/16.
 */
public class BookContent {
    public static class Book {
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<Book> books = new ArrayList<Book>();
    public static Map<Integer, Book> bookMap = new HashMap<Integer, Book>();

    private static void addBook(Book book) {
        books.add(book);
        bookMap.put(book.id, book);
    }

    static {
        addBook(new Book(1, "Java核心技术", "一本Java入门教程"));
        addBook(new Book(2, "深入理解Java虚拟机", "深入学习Java的经典书籍"));
        addBook(new Book(3, "J2EE企业实战", "java企业开发实用书籍"));
    }
}

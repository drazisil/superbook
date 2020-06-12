package com.drazisil.superbook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookObject {

    private final String bookName;

    BookObject(Map<?, ?> book) {
        this.bookName = (String) book.keySet().toArray()[0];
        HashMap<String, ?> bookData = (HashMap<String, ?>) book.values().toArray()[0];
        this.pages = (String[]) bookData.get("pages");

    }

    public String[] pages;
}

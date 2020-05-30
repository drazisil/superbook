package com.drazisil.rulebook;

import java.util.*;

public class SuperBook {

    public String name = "";
    public String desc = "";

    SuperBook(String bookKey) {

        String bookPath = String.format("books.%s", bookKey);

        Rulebook.logger.info(String.format("Key: %s", bookPath));

        // TODO: Fix null
        @SuppressWarnings("unchecked")
        ArrayList<String> book = (ArrayList<String>) Rulebook.plugin.getCustomConfig().get(bookPath);
        Rulebook.logger.info(String.format("Book: %s", book.get(book.indexOf(bookKey))));

//        String namePath = String.format("books.%s.name", bookKey);
//
//        String bookName = Rulebook.plugin.getCustomConfig().getString(namePath);
//        if (!(bookName == null)) this.name = bookName;

    }

//    public SuperBook(LinkedHashMap<String, String>[] bookData) {
//
//        Rulebook.logger.info(String.format("bookData Name: %s", bookData));
//    }

    public SuperBook(HashMap<String, String> book) {
        for (Map.Entry<String, String> setRecord : book.entrySet()) {
            System.out.println(setRecord);
        }
        this.name = book.get("name");

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SuperBook{name=" + getName() + '}';
    }
}

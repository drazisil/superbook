package com.drazisil.rulebook;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BookManager {

    private List<SuperBook> books = new ArrayList<>();

    BookManager(List<LinkedHashMap<String, String>> booksYaml) {
        if (booksYaml.size() <= 0) return;

        for (LinkedHashMap<String, String> rawBook: booksYaml) {

            // This is a single book

            String bookKey = (String) rawBook.keySet().toArray()[0];

            Rulebook.logger.info(rawBook.toString());
            SuperBook book = new SuperBook(bookKey);
            Rulebook.logger.info(book.toString());
            books.add(book);
        }

        listBooks();
    }

    private void listBooks() {
        Rulebook.logger.info("Listing books...");
        for (SuperBook book: books) {
            Rulebook.logger.info(String.format("Name: %s", book.getName()));
        }
    }
}

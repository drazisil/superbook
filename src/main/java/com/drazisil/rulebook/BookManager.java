package com.drazisil.rulebook;

import java.util.*;

public class BookManager {

    private List<SuperBook> books = new ArrayList<>();

    BookManager(List<Map<?, ?>> rawBooksYaml) {
        Rulebook.logger.info(String.format("RawBookYaml (%s): %s",
                rawBooksYaml.getClass().getName(),
                rawBooksYaml.toString()));

        for (Map<?, ?> book: rawBooksYaml) {
            Rulebook.logger.info(String.format("Book: %s", book));
            Rulebook.logger.info(String.format("Keys: %s", book.keySet().toArray()[0]));
            Rulebook.logger.info(String.format("Values: %s", book.values().toArray()[0]));
            @SuppressWarnings("unchecked")
            SuperBook sbook = new SuperBook((HashMap<String, String>) book.values().toArray()[0]);
            books.add(sbook);
        }
        listBooks();

    }


//    BookManager(List<LinkedHashMap<String, String>> booksYaml) {
//        if (booksYaml.size() <= 0) return;
//
//        for (LinkedHashMap<String, String> rawBook: booksYaml) {
//
//            // This is a single book
//
//            String bookKey = (String) rawBook.keySet().toArray()[0];
//
//            Rulebook.logger.info(String.format("rawBook: %s",rawBook.toString()));
//            SuperBook book = new SuperBook(bookKey);
//            Rulebook.logger.info(String.format("SuperBook: %s",book.toString()));
//            books.add(book);
//        }
//
//        listBooks();
//    }

    private void listBooks() {
        Rulebook.logger.info("Listing books...");
        for (SuperBook book: books) {
            Rulebook.logger.info(String.format("Name: %s", book.getName()));
        }
    }

}

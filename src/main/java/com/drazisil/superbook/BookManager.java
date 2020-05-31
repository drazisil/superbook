package com.drazisil.superbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookManager {

    private List<BookSuperBook> books = new ArrayList<>();

    BookManager(List<Map<?, ?>> rawBooksYaml) {
        SuperBook.logger.info(String.format("RawBookYaml (%s): %s",
                rawBooksYaml.getClass().getName(),
                rawBooksYaml.toString()));

        for (Map<?, ?> book: rawBooksYaml) {
            SuperBook.logger.info(String.format("Book: %s", book));
            SuperBook.logger.info(String.format("Keys: %s", book.keySet().toArray()[0]));
            SuperBook.logger.info(String.format("Values: %s", book.values().toArray()[0]));
            @SuppressWarnings("unchecked")
            BookSuperBook sbook = new BookSuperBook((String) book.keySet().toArray()[0], (HashMap<String, String>) book.values().toArray()[0]);
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
        SuperBook.logger.info("Listing books...");
        for (BookSuperBook book: books) {
            SuperBook.logger.info(String.format("Name: %s", book.getName()));
        }
    }

}

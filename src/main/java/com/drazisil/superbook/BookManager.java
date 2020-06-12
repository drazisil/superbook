package com.drazisil.superbook;

import java.util.*;

public class BookManager {

    private final List<BookSuperBook> books = new ArrayList<>();

    BookManager(List<Map<?, ?>> rawBooksYaml) {
        SuperBook.logger.info(String.format("RawBookYaml (%s): %s",
                rawBooksYaml.getClass().getName(),
                rawBooksYaml.toString()));

        for (Map<?, ?> book: rawBooksYaml) {
            SuperBook.logger.info(String.format("Book: %s", book));
            SuperBook.logger.info(String.format("Keys: %s", book.keySet().toArray()[0]));
            SuperBook.logger.info(String.format("Values: %s", book.values().toArray()[0]));

            @SuppressWarnings("unchecked")
            BookSuperBook sbook = new BookSuperBook(
                    (String) book.keySet().toArray()[0],
                    (HashMap<String, String>) book.values().toArray()[0]);
            books.add(sbook);
        }
        SuperBook.logger.info("Listing books...");
        ArrayList<String> bookList = listBooks();
        for (String bookEntry: bookList) {
            SuperBook.logger.info(bookEntry);
        }

    }


    public ArrayList<String> listBooks() {

        ArrayList<String> bookListing = new ArrayList<>();

        for (BookSuperBook book: books) {
            bookListing.add(String.format("Name: %s", book.getName()));
        }
        return bookListing;
    }

    public BookSuperBook getBookByKey(String bookKey) {

        for (BookSuperBook book: books) {
            if (book.getBookKey().equals(bookKey)) return book;
        }
        return null;
    }


}

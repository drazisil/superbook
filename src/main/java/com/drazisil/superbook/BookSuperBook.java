package com.drazisil.superbook;

import java.util.*;

public class BookSuperBook {

    private final String bookKey;
    private final String name;
    private final String desc;
    private final String cmd;
    private final String pages;

    public String getPages() {
        return pages;
    }

    private final String approvalCode;

    public String getBookKey() {
        return bookKey;
    }

    public String getDesc() {
        return desc;
    }

    public String getCmd() {
        return cmd;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    @SuppressWarnings("unchecked")
    public BookSuperBook(String bookKey, HashMap<String, ?> book) {

        this.bookKey = bookKey;
        this.name = (String) book.get("name");
        this.desc = (String) book.get("desc");
        this.cmd = (String) book.get("cmd");

        this.pages = String.valueOf(book.get("pages"));

        for (String page:((ArrayList<String>) book.get("pages"))) {
            System.out.printf("Page: %s%n", page);
        }


//        System.out.printf("Pages: %s%n", ((ArrayList<String>) book.get("pages")));

        // Approval code could be a number or a string.
        // TODO: find a way to not error if not a string in the YAML
        this.approvalCode = (String) book.get("approval_code");



    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SuperBook{name=" + getName() + '}';
    }
}

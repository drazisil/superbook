package com.drazisil.superbook;

import java.util.*;

public class BookSuperBook {

    private final String bookKey;
    private final String name;
    private final String desc;
    private final String cmd;
    private final HashSet<String> pages = new HashSet<>();
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

    public BookSuperBook(String bookKey, HashMap<String, String> book) {

        this.bookKey = bookKey;
        this.name = book.get("name");
        this.desc = book.get("desc");
        this.cmd = book.get("cmd");

        // Approval code could be a number or a string.
        // TODO: find a way to not error if not a string in the YAML
        this.approvalCode = book.get("approval_code");



    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SuperBook{name=" + getName() + '}';
    }
}

package com.drazisil.superbook;

import java.util.*;

public class BookSuperBook {

    private String bookKey = "";
    private String name = "";
    private String desc = "";
    private String cmd = "";
    private final HashSet<String> pages = new HashSet<String>();
    private String approvalCode = "";

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

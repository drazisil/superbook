package com.drazisil.rulebook;

import java.util.*;

public class SuperBook {

    private String name = "";

    SuperBook(String bookKey) {

        String bookName = (String) Rulebook.plugin.getConfig().get(String.format("books.%s.name", bookKey));
        if (!(bookName == null)) this.name = bookName;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SuperBook{name=" + getName() + '}';
    }
}

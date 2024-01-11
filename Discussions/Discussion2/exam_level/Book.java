package Discussions.Discussion2.exam_level;

public class Book {
    public String title;
    public Library library;
    // compiles if we add static

    public static Book last = null;
    // errors if we remove static

    public Book(String name) {
        title = name;
        last = this;
        library = null;
    }

    public static String lastBookTitle() {
        return last.title;
    }
    // changing this method to non-static would compile

    public String getTitle() {
        return title;
    }
}


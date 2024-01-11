package Discussions.Discussion2.exam_level;

public class Library {
    public Book[] books;
    public int index;
    public static int totalBooks = 0;
    // Changing to non static will not error

    public Library(int size) {
        books = new Book[size];
        index = 0;
    }

    public void addBook(Book book) {
        books[index] = book;
        index++;
        totalBooks++;
        book.library = this;
    }
    // changing this to static would error since books, index, total books are non static

    public static void main(String[] args) {

    }
}

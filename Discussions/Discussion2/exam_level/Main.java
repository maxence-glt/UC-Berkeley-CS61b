package Discussions.Discussion2.exam_level;

public class Main {
    public static void main(String[] args) {
        System.out.println(Library.totalBooks); // 0
        // System.out.println(Book.lastBookTitle());  error since its accessing null
        // System.out.println(Book.getTitle()); error since its accessing an instance method

        Book goneGirl = new Book("Gone Girl");
        Book fightClub = new Book("Fight Club");

        System.out.println(goneGirl.title); // Gone Girl
        System.out.println(Book.lastBookTitle()); // Fight Club
        System.out.println(fightClub.lastBookTitle()); // Fight Club
        System.out.println(goneGirl.last.title); // Fight Club

        Library libraryA = new Library(1);
        Library libraryB = new Library(2);
        libraryA.addBook(goneGirl);

        System.out.println(libraryA.index); // 1
        System.out.println(libraryA.totalBooks); // 1

        libraryA.totalBooks = 0;
        libraryB.addBook(fightClub);
        libraryB.addBook(goneGirl);

        System.out.println(libraryB.index); // 2
        System.out.println(Library.totalBooks); // 2
        System.out.println(goneGirl.library.books[0].title); // Fight Club

    }
}

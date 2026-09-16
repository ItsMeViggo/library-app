package se.iths.viggo.libraryapp;

import se.iths.viggo.libraryapp.model.Author;
import se.iths.viggo.libraryapp.model.Book;

public class Main {
    static void main() {
        Author author = new Author("JK Rowling");
        Book book = new Book("Harry Potter", "111123123", author);

        IO.println(book);
    }
}

package se.iths.viggo.libraryapp;

import se.iths.viggo.libraryapp.model.Author;
import se.iths.viggo.libraryapp.model.Book;
import se.iths.viggo.libraryapp.model.Borrower;
import se.iths.viggo.libraryapp.model.Loan;

public class Main {
    static void main() {
        Author author = new Author("JK Rowling");
        Book book = new Book("Harry Potter", "111123123", author);
        Borrower borrower = new Borrower("Kalle Johnasson", "KKR#¤%", "KallEJ");
        Loan loan = new Loan(borrower, book);

        IO.println(book);
        IO.println(borrower);
        IO.println(loan);
    }
}

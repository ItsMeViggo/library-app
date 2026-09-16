package se.iths.viggo.libraryapp;

import se.iths.viggo.libraryapp.model.Author;
import se.iths.viggo.libraryapp.model.Book;
import se.iths.viggo.libraryapp.model.Borrower;
import se.iths.viggo.libraryapp.model.Loan;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Borrower> borrowers = new ArrayList<>();
    static List<Book> books = new ArrayList<>();
    static List<Loan> loans = new ArrayList<>();

    static Borrower activeBorrower;

    static void main() {

        boolean running = true;

        borrowers.add(new Borrower("Anna Svensson", "anna123!", "AnnaS"));
        borrowers.add(new Borrower("Erik Nilsson", "Erik456!", "ErikN"));

        books.add(new Book("Bröderna Lejonhjärta", "12345678", new Author("Astrid Lindgren")));
        books.add(new Book("1984", "87654321", new Author("George Owell")));
        books.add(new Book("The hobbit", "13579245", new Author("JRR Tolkien")));


        login();

        if (activeBorrower != null) {
            while (running) {
                showMenu();

                String choice = IO.readln("What do you want to do? ");

                switch (choice) {
                    case "1" -> showAllBooks();
                    case "2" -> loanBook();
                    case "3" -> showAllLoans();
                    case "4" -> running = false;
                    default -> IO.println("Invalid input.");
                }
            }
        }

    }


    private static void login() {
        String username = IO.readln("Enter your username: ");
        String password = IO.readln("Enter your password: ");

        Borrower currentBorrower = null;

        for (Borrower borrower : borrowers) {
            if (borrower.getUsername().equals(username)
                    && borrower.getPassword().equals(password)) {
                currentBorrower = borrower;
                break;
            }
        }

        if (currentBorrower != null) {
            IO.println("Login Success!");
            activeBorrower = currentBorrower;
        } else {
            IO.println("Login Failed.");
        }
    }

    private static void showMenu() {
        String menu = """
                1. List all books
                2. Borrow book
                3. List all loans
                4. Quit menu
                """;

        IO.println(menu);


    }

    private static void showAllBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    private static void loanBook() {
        String isbn = IO.readln("ISBN: ");
        Book searchedBook = null;
        boolean isBorrowed = false;

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                searchedBook = book;
                break;
            }
        }

        if (searchedBook != null) {
            IO.println("Book found!");
        } else {
            IO.println("Book not found.");
        }

        checkIfBorrowed(searchedBook, isBorrowed);
    }

    private static void checkIfBorrowed(Book searchedBook, boolean isBorrowed) {
        for (Loan loan : loans) {
            if (searchedBook.equals(loan.getBook())) {
                isBorrowed = true;
                break;
            }
        }

        if (!isBorrowed) {
            loans.add(new Loan(activeBorrower, searchedBook));
            IO.println("Book borrowed!");
        } else {
            IO.println("Book is already borrowed..");
        }
    }

    private static void showAllLoans() {
        if (!loans.isEmpty()) {
            for (Loan loan : loans) {
                IO.println(loan);
            }
        } else {
            IO.println("List is empty.");
        }
    }

}

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

    static void main() {

        boolean running = true;

        borrowers.add(new Borrower("Anna Svensson", "anna123!", "AnnaS"));
        borrowers.add(new Borrower("Erik Nilsson", "Erik456!", "ErikN"));

        books.add(new Book("Bröderna Lejonhjärta", "12345678", new Author("Astrid Lindgren")));
        books.add(new Book("1984", "87654321", new Author("George Owell")));
        books.add(new Book("The hobbit", "13579245", new Author("JRR Tolkien")));

        loans.add(new Loan(borrowers.getFirst(), books.getFirst()));
        loans.add(new Loan(borrowers.getLast(), books.getLast()));

        login();

        while (running) {
            showMenu();

            String choice = IO.readln("What do you want to do? ");

            switch (choice) {
                case "1" -> {
                    for (Book book : books) {
                        IO.println(book);
                    }
                }
                case "2" -> running = false;
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
        } else {
            IO.println("Login Failed.");
        }
    }

    private static void showMenu() {
        String menu = """
                1. List all books
                2. Quit menu
                """;

        IO.println(menu);


    }
}

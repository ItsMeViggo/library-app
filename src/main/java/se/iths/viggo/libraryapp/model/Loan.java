package se.iths.viggo.libraryapp.model;

import java.time.LocalDateTime;

public class Loan {
    private final LocalDateTime loanDate;
    private final Borrower borrower;
    private final Book book;

    public Loan(final Borrower borrower, final Book book) {
        this.borrower = borrower;
        this.book = book;
        this.loanDate = LocalDateTime.now();
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanDate=" + loanDate +
                ", borrower=" + borrower +
                ", book=" + book +
                '}';
    }
}

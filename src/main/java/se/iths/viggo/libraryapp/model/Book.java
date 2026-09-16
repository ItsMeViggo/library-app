package se.iths.viggo.libraryapp.model;

public class Book {
    private final String title;
    private String isbn;
    private final Author author;

    public Book(final String title, final String isbn, final Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                author +
                '}';
    }
}

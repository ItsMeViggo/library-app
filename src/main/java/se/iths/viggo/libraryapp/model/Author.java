package se.iths.viggo.libraryapp.model;

public class Author {
    private final String name;

    public Author(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "The author's name is: " + name;
    }
}

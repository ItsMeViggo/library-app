package se.iths.viggo.libraryapp.model;

public class Borrower {
    private String username;
    private String password;
    private final String name;

    public Borrower(final String name, final String password, final String username) {
        this.name = name;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


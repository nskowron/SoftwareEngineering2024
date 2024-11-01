package app;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
    private String name;
    private String lastName;
    private String email;

    private List<Book> books;

    public Customer(String name, String lastName, String email)
    {
        this.name = name;
        this.lastName = lastName;
        this.email = email;

        this.books = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void borrowBook(Book book)
    {
        books.add(book);
    }

    public void returnBook(Book book)
    {
        books.remove(book);
    }
}

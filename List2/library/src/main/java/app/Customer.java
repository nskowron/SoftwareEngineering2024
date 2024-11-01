package app;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
    private int ID;

    private String name;
    private String lastName;
    private String email;

    private List<Book> books;

    public Customer(int ID, String name, String lastName, String email, List<Book> books)
    {
        this.ID = ID;

        this.name = name;
        this.lastName = lastName;
        this.email = email;

        this.books = books;
    }

    public Customer(String name, String lastName, String email)
    {
        this(-1, name, lastName, email, new ArrayList<Book>());
    }

    public int getID()
    {
        return ID;
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

    public List<Book> getBooks()
    {
        return books;
    }

    public void borrowBook(Book book) throws IllegalArgumentException
    {
        if(books.contains(book))
        {
            throw new IllegalArgumentException("Customer has already borrowed " + book.getTitle());
        }

        books.add(book);
    }

    public void returnBook(Book book) throws IllegalArgumentException
    {
        if(!books.contains(book))
        {
            throw new IllegalArgumentException("Customer has not borrowed " + book.getTitle());
        }

        books.remove(book);
    }
}

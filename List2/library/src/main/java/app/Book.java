package app;

import java.util.Objects;

public class Book
{
    private int ID;

    private String title;
    private String author;

    private boolean available;
    private int ownerID;

    public Book(int ID, String title, String author, boolean available, int ownerID)
    {
        this.ID = ID;

        this.title = title;
        this.author = author;

        this.available = available;
        this.ownerID = ownerID;
    }

    public Book(String title, String author)
    {
        this(-1, title, author, true, -1);
    }

    public int getID()
    {
        return ID;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public int getOwnerID()
    {
        return ownerID;
    }

    public void borrowBook(int customerID) throws IllegalAccessException
    {
        if(available == false)
        {
            throw new IllegalAccessException("Book is already borrowed");
        }

        ownerID = customerID;
        available = false;
    }

    public void returnBook() throws IllegalAccessException
    {
        if(available)
        {
            throw new IllegalAccessException("Book is not borrowed by anyone");
        }

        ownerID = -1;
        available = true;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Book book = (Book) obj;
        return this.ID == book.getID() && title.equals(book.getTitle()) && author.equals(book.getAuthor());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(ID, title, author, available);
    }
}

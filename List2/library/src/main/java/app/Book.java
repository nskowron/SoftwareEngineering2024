package app;

public class Book
{
    private int ID;

    private String title;
    private String author;

    private boolean available;

    public Book(int ID, String title, String author, boolean available)
    {
        this.ID = ID;

        this.title = title;
        this.author = author;

        this.available = available;
    }

    public Book(String title, String author)
    {
        this(-1, title, author, true);
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

    public void setAvailable(boolean available)
    {
        this.available = available;
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
}

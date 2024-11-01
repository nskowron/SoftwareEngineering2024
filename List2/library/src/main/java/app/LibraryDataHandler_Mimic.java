package app;

import java.io.IOException;
import java.util.List;

public class LibraryDataHandler_Mimic extends LibraryDataHandler
{
    // Adding new data to the system
    public abstract void addNewBook(Book book) throws IOException;
    public abstract void addNewCustomer(Customer customer) throws IOException;

    // Updating system data (eg. when borrowing a book)
    public abstract void updateBook(int ID, Book updatedBook) throws IOException;
    public abstract void updateCustomer(int ID, Customer updatedCustomer) throws IOException;

    // Searching for book copies
    public abstract Book getBook(int ID) throws IOException;
    public abstract List<Book> getBooks(String title) throws IOException;
    public List<Book> getBooks() throws IOException
    {
        return getBooks("");
    }

    // Searching for distinct titles
    public abstract List<Book> getTitles(String title) throws IOException;
    public List<Book> getTitles() throws IOException
    {
        return getTitles("");
    }

    // Searching for customer info
    public abstract Customer getCustomer(int ID) throws IOException;
    public abstract Customer getCustomerByEmail(String email) throws IOException;
}

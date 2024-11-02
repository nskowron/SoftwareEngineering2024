package app;

import java.io.IOException;
import java.util.List;

public abstract class LibraryDataHandler
{
    // Adding new data to the system
    public abstract int addNewBook(Book book) throws IOException;
    public abstract int addNewCustomer(Customer customer) throws IOException;

    // Updating system data (eg. when borrowing a book)
    public abstract void updateBook(int ID, Book updatedBook) throws IOException;
    public abstract void updateCustomer(int ID, Customer updatedCustomer) throws IOException;

    // Searching for book copies
    public abstract Book getBook(int ID) throws IOException;
    public abstract List<Book> getBooks(String title) throws IOException;
    public abstract List<Book> getBooks() throws IOException;

    // Searching for distinct titles
    public abstract List<Book> getTitles(String title) throws IOException;
    public abstract List<Book> getTitles() throws IOException;

    // Searching for customer info
    public abstract Customer getCustomer(int ID) throws IOException;
    public abstract Customer getCustomerByEmail(String email) throws IOException;

    // Borrowing and returning books
    public void borrowBook(Customer customer, Book book) throws IllegalAccessException, IOException
    {
        customer.borrowBook(book);
        book.borrowBook(customer.getID());

        updateCustomer(customer.getID(), customer);
        updateBook(book.getID(), book);
    }

    public void returnBook(Book book) throws IllegalAccessException, IOException
    {
        Customer customer = getCustomer(book.getOwnerID());
        customer.returnBook(book);
        book.returnBook();

        updateCustomer(customer.getID(), customer);
        updateBook(book.getID(), book);
    }
}

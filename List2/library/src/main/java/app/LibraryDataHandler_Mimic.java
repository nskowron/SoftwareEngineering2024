package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDataHandler_Mimic extends LibraryDataHandler
{
    private List<Book> books;
    private List<Customer> customers;

    public LibraryDataHandler_Mimic()
    {
        this.books = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Adding new data to the system
    public int addNewBook(Book book) throws IOException
    {
        Book assigned = new Book(books.size(), book.getTitle(), book.getAuthor(), book.isAvailable());
        book = assigned;
        books.add(book);

        return book.getID();
    }

    public int addNewCustomer(Customer customer) throws IOException
    {
        Customer assigned = new Customer(customers.size(), customer.getName(), customer.getLastName(), customer.getEmail(), customer.getBooks());
        customer = assigned;
        customers.add(customer);

        return customer.getID();
    }

    // Updating system data (eg. when borrowing a book)
    public void updateBook(int ID, Book updatedBook) throws IOException
    {
        boolean found = false;

        for(Book book : books)
        {
            if(book.getID() == ID)
            {
                found = true;
                book = updatedBook;
            }
        }

        if(found == false)
        {
            throw new IOException("Wrong ID");
        }
    }

    public void updateCustomer(int ID, Customer updatedCustomer) throws IOException
    {
        boolean found = false;

        for(Customer customer : customers)
        {
            if(customer.getID() == ID)
            {
                found = true;
                customer = updatedCustomer;
            }
        }

        if(found == false)
        {
            throw new IOException("Wrong ID");
        }
    }

    // Searching for book copies
    public Book getBook(int ID) throws IOException
    {
        for(Book book : books)
        {
            if(book.getID() == ID)
            {
                return book;
            }
        }

        throw new IOException("Wrong ID");
    }

    public List<Book> getBooks(String title) throws IOException
    {
        List<Book> matching = new ArrayList<>();

        for(Book book : books)
        {
            if(book.getTitle().contains(title))
            {
                matching.add(book);
            }
        }

        return matching;
    }

    public List<Book> getBooks() throws IOException
    {
        return getBooks("");
    }

    // Searching for distinct titles
    public List<Book> getTitles(String title) throws IOException
    {
        throw new IOException("""
                        Because this is just a mimic of a real data handler 
                        and does not have a real database with a search engine, 
                        this method is not implemented""");
    }

    public List<Book> getTitles() throws IOException
    {
        return getTitles("");
    }

    // Searching for customer info
    public Customer getCustomer(int ID) throws IOException
    {
        for(Customer customer : customers)
        {
            if(customer.getID() == ID)
            {
                return customer;
            }
        }

        throw new IOException("Wrong ID");
    }

    public Customer getCustomerByEmail(String email) throws IOException
    {
        for(Customer customer : customers)
        {
            if(customer.getEmail() == email)
            {
                return customer;
            }
        }

        throw new IOException("Wrong ID");
    }
}

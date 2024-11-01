package app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.IO.Color;

public class RunCrs implements Runnable
{
    private Map<String, Runnable> options;

    public RunCrs(LibraryDataHandler library)
    {
        this.options = new HashMap<>();

        Runnable borrowBook = () -> 
        {
            try
            {
                IO.out("Customer's ID: ");
                int customerID = Integer.parseInt(IO.in());
                IO.out("Book ID: ");
                int bookID = Integer.parseInt(IO.in());

                Customer customer = library.getCustomer(customerID);
                Book book = library.getBook(bookID);

                library.borrowBook(customer, book);

                IO.out("\nSuccessfully rented " + book.getTitle() + " to " + customer.getName() + " " + customer.getLastName() + "\n", Color.GREEN);
            }
            catch(NumberFormatException e)
            {
                IO.out("\nInvalid ID - needs to be a number\n", Color.RED);
            }
            catch(IOException | IllegalArgumentException e)
            {
                IO.out("\n" + e.getMessage() + "\n", Color.RED);
            }
        };

        options.put("b", borrowBook);
        options.put("B", borrowBook);

        Runnable returnBook = () -> 
        {
            try
            {
                IO.out("Customer's ID: ");
                int customerID = Integer.parseInt(IO.in());
                IO.out("Book ID: ");
                int bookID = Integer.parseInt(IO.in());

                Customer customer = library.getCustomer(customerID);
                Book book = library.getBook(bookID);

                library.returnBook(library.getCustomer(customerID), library.getBook(bookID));

                IO.out("\nSuccessfully picked up " + book.getTitle() + " from " + customer.getName() + " " + customer.getLastName() + "\n", Color.GREEN);
            }
            catch(NumberFormatException e)
            {
                IO.out("\nInvalid ID - needs to be a number\n", Color.RED);
            }
            catch(IOException | IllegalArgumentException e)
            {
                IO.out("\n" + e.getMessage() + "\n", Color.RED);
            }
        };

        options.put("r", returnBook);
        options.put("R", returnBook);

        Runnable changeEmail = () -> 
        {
            try
            {
                IO.out("Customer's ID: ");
                int customerID = Integer.parseInt(IO.in());
                IO.out("Customer's new email address: ");
                String email = IO.in();

                Customer customer = library.getCustomer(customerID);
                Customer updated = new Customer(customer.getID(), customer.getName(), customer.getLastName(), email, customer.getBooks());

                library.updateCustomer(customerID, updated);

                IO.out("\nSuccessfully changed " + customer.getName() + " " + customer.getLastName() + "'s email address to " + email + "\n", Color.GREEN);
            }
            catch(NumberFormatException e)
            {
                IO.out("\nInvalid ID - needs to be a number\n", Color.RED);
            }
            catch(IOException | IllegalArgumentException e)
            {
                IO.out("\n" + e.getMessage() + "\n", Color.RED);
            }
        };

        options.put("e", changeEmail);
        options.put("E", changeEmail);
    }

    public void run()
    {
        new ChoiceBox("\nBorrow / Return a book or change customer's Email address [bre]: ", options);
    }
}

package app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.IO.Color;

public class RunAdd implements Runnable
{
    private Map<String, Runnable> options;

    public RunAdd(LibraryDataHandler library)
    {
        this.options = new HashMap<>();

        Runnable newCustomer = () -> 
        {
            IO.out("Customer's first name: ");
            String name = IO.in();
            IO.out("Customer's last name: ");
            String lastName = IO.in();
            IO.out("Customer's email address: ");
            String email = IO.in();

            try
            {
                library.addNewCustomer(new Customer(name, lastName, email));
                IO.out("\nSuccessfully added new customer\n", Color.GREEN);
            }
            catch(IOException | IllegalArgumentException e)
            {
                IO.out("\n" + e.getMessage() + "\n", Color.RED);
            }
        };

        options.put("c", newCustomer);
        options.put("C", newCustomer);

        Runnable newBook = () -> 
        {
            IO.out("Book title: ");
            String title = IO.in();
            IO.out("Book author: ");
            String author = IO.in();

            try
            {
                library.addNewBook(new Book(title, author));
                IO.out("\nSuccessfully added new book\n", Color.GREEN);
            }
            catch(IOException | IllegalArgumentException e)
            {
                IO.out("\n" + e.getMessage() + "\n", Color.RED);
            }
        };

        options.put("b", newBook);
        options.put("B", newBook);
    }

    public void run()
    {
        new ChoiceBox("\nAdd new Customer or Book [cb]: ", options);
    }
}

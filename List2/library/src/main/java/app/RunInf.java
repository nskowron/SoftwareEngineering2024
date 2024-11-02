package app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.IO.Color;

public class RunInf extends CleanRunnable
{
    private Map<String, Runnable> options;

    public RunInf(LibraryDataHandler library)
    {
        this.options = new HashMap<>();

        Runnable customerInfo = () -> 
        {
            IO.out("Customer's ID or email: ");
            String email = IO.in();

            Customer customer;
            try
            {
                try
                {
                    int ID = Integer.parseInt(email);
                    customer = library.getCustomer(ID);
                }
                catch(NumberFormatException e)
                {
                    customer = library.getCustomerByEmail(email);
                }

                IO.out("\nCustomer Info\n", Color.GREEN);
                IO.out(
                    "\nID: " + customer.getID() +
                    "\nName: " + customer.getName() +
                    "\nLast Name: " + customer.getLastName() +
                    "\nemail: " + customer.getEmail() +
                    "\nbooks: "
                );
                for(Book book : customer.getBooks())
                {
                    IO.out(book.getTitle() + " ");
                }
                IO.out("\n");

                IO.out("\n(enter)\n");
                IO.in();
            }
            catch(IOException e)
            {
                IO.out("\n" + e.getMessage() + "\n", Color.RED);

                IO.out("\n(enter)\n");
                IO.in();
            }
        };

        options.put("c", customerInfo);
        options.put("C", customerInfo);

        Runnable bookInfo = () -> 
        {
            try
            {
                IO.out("Book ID: ");
                int bookID = Integer.parseInt(IO.in());

                Book book = library.getBook(bookID);

                IO.out("\nBook Info\n", Color.GREEN);
                IO.out(
                    "\nBook ID: " + book.getID() +
                    "\nBook title: " + book.getTitle() +
                    "\nBook author: " + book.getAuthor() +
                    "\nAvailability: "
                );
                if(book.isAvailable())
                {
                    IO.out("Available", Color.GREEN);
                }
                else
                {
                    IO.out("Not available", Color.RED);
                }
                IO.out("\n");

                IO.out("\n(enter)\n");
                IO.in();
            }
            catch(NumberFormatException e)
            {
                IO.out("\nInvalid ID - needs to be a number\n", Color.RED);

                IO.out("\n(enter)\n");
                IO.in();
            }
            catch(IOException | IllegalArgumentException e)
            {
                IO.out("\n" + e.getMessage() + "\n", Color.RED);

                IO.out("\n(enter)\n");
                IO.in();
            }
        };

        options.put("b", bookInfo);
        options.put("B", bookInfo);

        Runnable searchCatalog = new RunSearchCatalog(library);
        options.put("s", searchCatalog);
        options.put("S", searchCatalog);
    }

    @Override
    public void run()
    {
        super.run();
        new ChoiceBox("Get info about a Customer, Book or Search the catalog [cbs]: ", options);
    }
}


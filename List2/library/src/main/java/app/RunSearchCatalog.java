package app;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import app.IO.Color;

public final class RunSearchCatalog extends CleanRunnable
{
    private AtomicBoolean running;
    private Map<String, Runnable> options;

    public RunSearchCatalog(final LibraryDataHandler library)
    {
        running = new AtomicBoolean(true);
        options = new HashMap<>();

        options.put("a", () ->
        {
            try
            {
                List<Book> books = library.getBooks();

                IO.out("\nAll our books\n");
                for(Book book : books)
                {
                    IO.out(
                        "\n" + book.getID() + ". " +
                        book.getTitle() + " by " + book.getAuthor() + " ");

                    if(book.isAvailable())
                    {
                        IO.out("Available", Color.GREEN);
                    }
                    else
                    {
                        IO.out("Not available", Color.RED);
                    }
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
        });
        options.put("A", options.get("a"));

        options.put("t", ()  ->
        {
            IO.out("Title: ");
            String title = IO.in();

            try
            {
                List<Book> books = library.getBooks(title);

                IO.out("\nAll matching books\n");
                for(Book book : books)
                {
                    IO.out(
                        "\n" + book.getID() + ". " +
                        book.getTitle() + " by " + book.getAuthor() + " ");

                    if(book.isAvailable())
                    {
                        IO.out("Available", Color.GREEN);
                    }
                    else
                    {
                        IO.out("Not available", Color.RED);
                    }
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
        });
        options.put("T", options.get("t"));

        options.put("q", () -> { running.set(false); });
        options.put("Q", options.get("q"));
    }

    @Override
    public void run()
    {
        super.run();

        running.set(true);
        while(running.get())
        {
            new ChoiceBox("""
                    Show All books [a]
                    Search books by Title [t]
                    Quit catalog [q]

                    What do you want to do?: 
                    """, options);

            super.run();
        }
    }
}

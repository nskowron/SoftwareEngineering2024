package app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import app.IO.Color;

public class UI
{
    public UI(LibraryDataHandler library)
    {
        IO.out("\n\nLibrary system up. Welcome.\n\n", Color.GREEN);


        Map<String, Runnable> choices = new HashMap<>();

        Runnable add = new RunAdd(library);
        choices.put("a", add);
        choices.put("A", add);

        Runnable crs = new RunCrs(library);
        choices.put("c", crs);
        choices.put("C", crs);

        AtomicBoolean running = new AtomicBoolean(true);

        Runnable quit = () -> { running.set(false); };
        choices.put("q", quit);
        choices.put("Q", quit);

        while(running.get())
        {
            new ChoiceBox("""
                    Add something new to the system [a]\n
                    Consumer related stuff (borrowing books etc.) [c]\n
                    Quit system [q]\n
                    \n
                    What do you want to do?: 
                    """, choices);
        }

        
        IO.out("\n\nSystem shutdown...\n\n", Color.RED);
    }
}

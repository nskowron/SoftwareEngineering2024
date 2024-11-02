package app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import app.IO.Color;

public class UI extends CleanRunnable
{
    private AtomicBoolean running;
    private Map<String, Runnable> choices;

    public UI(LibraryDataHandler library)
    {
        running = new AtomicBoolean(true);
        choices = new HashMap<>();

        Runnable add = new RunAdd(library);
        choices.put("a", add);
        choices.put("A", add);

        Runnable crs = new RunCrs(library);
        choices.put("c", crs);
        choices.put("C", crs);

        Runnable inf = new RunInf(library);
        choices.put("i", inf);
        choices.put("I", inf);

        Runnable quit = () -> { running.set(false); };
        choices.put("q", quit);
        choices.put("Q", quit);
    }

    @Override
    public void run()
    {
        super.run();
        IO.out("\n\nLibrary system up. Welcome.\n\n", Color.GREEN);

        while(running.get())
        {
            new ChoiceBox("""
                    Add something new to the system [a]
                    Consumer related stuff (borrowing books etc.) [c]
                    Get Info about something [i]
                    Quit system [q]
                    
                    What do you want to do?:  """, choices);

            super.run();
        }

        IO.out("\n\nSystem shutdown...\n\n", Color.RED);
    }
}

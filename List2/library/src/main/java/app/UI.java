package app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import app.IO.Color;

public class UI extends CleanRunnable
{
    private AtomicBoolean running;
    private Map<String, Runnable> choices;

    public UI(final LibraryDataHandler library)
    {
        this.running = new AtomicBoolean(true);
        this.choices = new HashMap<>();

        choices.put("a", new RunAdd(library));
        choices.put("A", choices.get("a"));

        choices.put("c", new RunCrs(library));
        choices.put("C", choices.get("c"));

        choices.put("i", new RunInf(library));
        choices.put("I", choices.get("i"));

        choices.put("q", () -> { running.set(false); });
        choices.put("Q", choices.get("q"));
    }

    @Override
    public void run()
    {
        super.run();

        running.set(true);
        IO.out("\n\nLibrary system up. Welcome.\n\n", Color.GREEN);

        while(running.get())
        {
            new ChoiceBox(
                    "Add something new to the system [a]" +
                    "\nConsumer related stuff (borrowing books etc.) [c]" +
                    "\nGet Info about something [i]" +
                    "\nQuit system [q]" +
                    "\n\nWhat do you want to do?: ", choices);

            super.run();
        }

        IO.out("\n\nSystem shutdown...\n\n", Color.RED);
    }
}

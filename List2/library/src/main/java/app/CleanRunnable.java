package app;

public class CleanRunnable implements Runnable
{
    public void run()
    {
        IO.out("\033[2J\033[H");
    }
}

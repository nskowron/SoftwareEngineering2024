package rt.app;

import java.util.Random;

public class Test implements Runnable
{
    private static Random random = new Random();

    public void run()
    {
        IO.out("\n\n\n");

        try
        {
            Thread.sleep(random.nextInt(2000) + 1000);
        }
        catch(InterruptedException e)
        {
            IO.out("Error: Program has been interrupted, failed to run test\n", IO.Color.RED);
            System.exit(1);
        }

        long start, end;

        IO.out("###", IO.Color.RED);
        start = System.currentTimeMillis();
        IO.in();
        end = System.currentTimeMillis();

        long score = end - start;
        IO.out("\nYour score is ", IO.Color.WHITE);
        IO.out(Long.toString(score), IO.Color.GREEN);
        IO.out(score < 5 ? "ms, godlike... suspicious...\n\n" : "ms, congratulations!\n\n", IO.Color.WHITE);
    }
}

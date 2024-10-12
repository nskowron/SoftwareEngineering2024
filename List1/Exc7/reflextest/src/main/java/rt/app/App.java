package rt.app;

import java.util.HashMap;

public class App
{
    public static void main(String[] args)
    {
        IO.out("~ Welcome to ReflexTest! ~\n\n", IO.Color.GREEN);

        HashMap<String, Runnable> choices = new HashMap<>();

        Runnable quit = () -> {};
        choices.put("q", quit);
        choices.put("Q", quit);
        choices.put("quit", quit);
        choices.put("Quit", quit);

        IO.out("Start new test, or Quit [sq]? : ");
        new ChoiceBox(choices);
    }
}

package app;

import java.util.HashMap;

public class ChoiceBox
{
    public ChoiceBox(final String prompt, final HashMap<String, Runnable> choices)
    {
        IO.out(prompt);
        
        String choice = IO.in();
        if(choices.containsKey(choice))
        {
            choices.get(choice).run();
        }
        else
        {
            IO.out("Error: unknown option: " + choice + "\n", IO.Color.RED);
        }
    }
}

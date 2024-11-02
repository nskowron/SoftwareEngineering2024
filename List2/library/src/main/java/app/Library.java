package app;

public class Library
{
    public static void main(String[] args)
    {
        LibraryDataHandler library = new LibraryDataHandler_Mimic();
        UI ui = new UI(library);
        ui.run();
    }
}

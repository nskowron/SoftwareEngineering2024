package app;

public class Library
{
    public static void main(String[] args)
    {
        LibraryDataHandler library = new LibraryDataHandler_Mimic();
        new UI(library);
    }
}

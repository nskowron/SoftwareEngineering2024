package app;

public final class Library
{
    private Library() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of a static class Library");
    }

    public static void main(final String[] args)
    {
        LibraryDataHandler library = new LibraryDataHandler_Mimic();
        UI ui = new UI(library);
        ui.run();
    }
}

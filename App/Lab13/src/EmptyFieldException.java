public class EmptyFieldException extends Exception{
    EmptyFieldException()
    {
        super("Name of the video is not set");
    }

    EmptyFieldException(String message)
    {
        super(message);
    }

    EmptyFieldException(String message, Throwable err)
    {
        super(message, err);
    }
}

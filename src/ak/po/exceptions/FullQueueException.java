package ak.po.exceptions;

public class FullQueueException extends RuntimeException
{
    public FullQueueException(String message)
    {
        super(message);
    }
}
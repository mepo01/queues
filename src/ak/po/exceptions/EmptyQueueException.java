package ak.po.exceptions;

public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException(String message)
    {
        super(message);
    }
}
package ak.po;

public class User
{
    private int time;

    public User(int time)
    {
        setTime(time);
    }
    public int getTime()
    {
        return time;
    }
    public void setTime(int t)
    {
        time = t;
    }
    public String toString()
    {
        return "" + time;
    }
}

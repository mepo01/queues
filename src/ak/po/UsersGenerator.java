package ak.po;

import java.util.Random;

public class UsersGenerator {
    private static double p = 0.8;
    private static int maxTime = 10;
    private static Random generator = new Random();

    public static void setMaxTime(int mt)
    {
        maxTime = mt;
    }
    public static User getUser()
    {
        if(generator.nextDouble() < p)
            return new User(generator.nextInt(maxTime) + 1);
        else
            return null;
    }
}

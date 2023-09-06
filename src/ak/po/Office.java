package ak.po;

import ak.po.exceptions.EmptyQueueException;
import ak.po.queues.ArrayFifo;
import ak.po.queues.ListFifo;

public class Office
{
    private int workplaceNumber;
    private int time, maxTime;
    private int workplaces[];
    private ListFifo q;

    public Office(int wpn, int mt)
    {
        workplaceNumber = wpn;
        workplaces = new int[workplaceNumber];
        UsersGenerator.setMaxTime(10);
        maxTime = mt;
        time = 0;
        for (int i=0; i<workplaceNumber; i++) {
            workplaces[i] = 0;
        }
        q = new ListFifo(100);
    }

    public void addToQueue(User user) {
         if (user != null) {
             q.enqueue(user);
         }
         /**
         * Uzupełnić brakujący kod
         */
    }

    private void upadateWorkplaces()
    {
        time++;
        User temp = null;
        for (int i = 0; i < workplaceNumber ; i++) {
            if(workplaces[i] == 0 && !q.isEmpty()) {
                temp = (User) q.dequeue();
                workplaces[i] = temp.getTime();
            } else if(workplaces[i] > 0) {
                workplaces[i] -= 1;
            }
        }

        /**
         * Uzupełnić brakujący kod
         */
    }

    public String toString()
    {
        String tmp = "Godz: " + time + " - " + q.toString() + "\nStan okienek: ";
        for (int i=0; i<workplaceNumber; i++) {
            tmp += i + ":" + workplaces[i] + "; ";
        }
        return tmp + "\n";
    }

    public void run()
    {
        do {
            addToQueue(UsersGenerator.getUser());
            upadateWorkplaces();
            System.out.println(this.toString());
            if (time > maxTime) {
                break;
            }
        } while (time < maxTime || !q.isEmpty()) ;
        while (!q.isEmpty()){
            upadateWorkplaces();
            System.out.println(this.toString());
        }
    }
}
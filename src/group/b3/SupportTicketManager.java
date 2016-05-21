package group.b3;

import java.util.ArrayList;
import java.util.Vector;

public class SupportTicketManager
{
    private ArrayList<SupportTicket> tickets;

    public SupportTicketManager()
    {
        tickets = new ArrayList<>();
    }

    public void addTicket(String message, Customer owner)
    {
        tickets.add(new SupportTicket(message, owner));
    }

    public Vector<SupportTicket> getUnsolvedTickets() {
        Vector<SupportTicket> solved = new Vector<>();

        tickets.forEach(t->
        {
            if(!t.isSolved())
                solved.add(t);
        });

        return solved;
    }
}

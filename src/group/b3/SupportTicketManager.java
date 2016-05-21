package group.b3;

import java.io.*;
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

    public void saveToFile()
    {
        try {
            FileOutputStream fout = new FileOutputStream("tickets.data");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(tickets);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile()
    {
        try {
            FileInputStream fin = new FileInputStream("tickets.data");
            ObjectInputStream ois = new ObjectInputStream(fin);
            tickets = (ArrayList<SupportTicket>) ois.readObject();
            fin.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

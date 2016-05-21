package group.b3;

import java.io.Serializable;
import java.util.Date;


public class SupportTicket implements Serializable{
    private String message;
    private Customer owner;
    private boolean solved;
    private Date created;

    public SupportTicket(String message, Customer owner) {
        this.message = message;
        this.owner = owner;
        this.solved = false;
        this.created = new Date();
    }

    public String getMessage() {
        return message;
    }

    public Customer getOwner() {
        return owner;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public Date getCreated() {
        return created;
    }


    @Override
    public String toString() {
        return created.toString() + (solved ? " Solved " : " Unsolved ") + " by " + owner.getName();
    }
}

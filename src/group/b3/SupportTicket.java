package group.b3;

import java.util.Date;


public class SupportTicket {
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

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
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

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return created.toString() + (solved ? " Solved " : " Unsolved ") + " by " + owner.getName();
    }
}

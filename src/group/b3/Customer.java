package group.b3;

/**
 * Created by henkv on 2016-05-12.
 */
public class Customer extends User {
    private float balance;

    public Customer(String name, String password, float balance) {
        super(name, password);
        this.balance = balance;
    }

    public void addMoney(float amount)
    {
        balance += amount;
    }

    public void removeMoney(float amount)
    {
        balance -= amount;
    }

    public float getBalance()
    {
        return balance;
    }

    public void setBalance(float balance)
    {
        this.balance = balance;
    }
}

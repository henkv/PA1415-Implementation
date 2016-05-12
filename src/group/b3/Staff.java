package group.b3;

public class Staff extends User {
    private float salary;

    public Staff(String name, String password, float salary) {
        super(name, password);
        this.salary = salary;
    }

    public float getSalary(){
        return salary;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

}

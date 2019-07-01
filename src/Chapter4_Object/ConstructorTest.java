package Chapter4_Object;

import java.util.Random;

public class ConstructorTest {
    public static void main(String[] args) {
        Employee4[] staff = new Employee4[3];

        staff[0] = new Employee4("Harry",40000);
        staff[1] = new Employee4(60000);
        staff[2] = new Employee4();

        for(Employee4 e : staff){
            System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
        }
    }
}

class Employee4{
    private static int nextId;

    private int id;
    private String name ="";
    private double salary;

    //static initialization block
    static {
        Random generator = new Random();
        nextId = generator.nextInt();
    }

    //obejct initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee4(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee4(double salary) {
        this("Employee4 #"+nextId, salary);
    }

    public Employee4() {
        //Every parameters initialized
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
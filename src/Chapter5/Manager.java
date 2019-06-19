package Chapter5;

import Chapter4.Employee;

public class Manager extends Employee {
    private double bouns;

    public Manager(String n, double s, int year, int month, int day){
        super(n, s, year, month, day);
        bouns = 0;
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bouns;
    }

    public void setBouns(double b){
        bouns = b;
    }
}

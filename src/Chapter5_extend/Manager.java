package Chapter5_extend;

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

    public double getBouns() {
        return bouns;
    }

    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        return bouns == other.bouns;
    }

    public int hashCode(){
        return super.hashCode()+17*new Double(bouns).hashCode();
    }

    public String toString(){
        return super.toString()+"[bonus="+bouns+"]";
    }
}

package collection;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) { //负数：小于，0：等于，正数：大于

        if (this.getSalary() > o.getSalary()){
            return 1;
        }else if (this.getSalary() < o.getSalary()){
            return -1;
        }else {
            if (this.getId() > o.getId()){
                return 1;
            }else if (this.getId() < o.getId()){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

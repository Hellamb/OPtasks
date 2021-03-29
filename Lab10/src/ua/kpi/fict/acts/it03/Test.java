package ua.kpi.fict.acts.it03;

public class Test {
    private String name;
    private double value;

    public Test(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
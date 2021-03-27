package ua.kpi.fict.acts.it03;

public class Test {

    private double value;
    private String name;

    public Test(String name, double value)
    {
        this.name = name;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}

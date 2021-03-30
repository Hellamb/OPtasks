import java.util.Objects;

public abstract class Medicine {
    protected String name;
    protected int receiveFrequencyPerDay;
    protected int actionTime;
    protected String disease;
    protected int price;

    public Medicine(String name, int receiveFrequencyPerDay, int actionTime, String disease, int price)
    {
        this.name = name;
        this.receiveFrequencyPerDay = receiveFrequencyPerDay;
        this.actionTime = actionTime;
        this.disease = disease;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getReceiveFrequencyPerDay() {
        return receiveFrequencyPerDay;
    }

    public int getActionTime() {
        return actionTime;
    }

    public String getDisease() {
        return disease;
    }

    public int getPrice(){
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReceiveFrequencyPerDay(int receiveFrequencyPerDay) {
        this.receiveFrequencyPerDay = receiveFrequencyPerDay;
    }

    public void setActionTime(int actionTime) {
        this.actionTime = actionTime;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return receiveFrequencyPerDay == medicine.receiveFrequencyPerDay &&
                actionTime == medicine.actionTime &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(disease, medicine.disease);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", receiveFrequencyPerDay=" + receiveFrequencyPerDay +
                ", actionTime=" + actionTime +
                ", disease='" + disease + '\'' +
                '}';
    }
    public String toString(int i) {
        return  "name='" + name + '\'' +
                ", receiveFrequencyPerDay=" + receiveFrequencyPerDay +
                ", actionTime=" + actionTime +
                ", disease='" + disease + '\'';
    }
}

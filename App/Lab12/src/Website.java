import java.util.HashMap;
import java.util.Objects;

public class Website {
    private String name;
    private HashMap<String,Vlog> vlogs = new HashMap<>();

    public Website(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addVlog(Vlog vl)
    {
        this.vlogs.put(vl.getAuthor(),vl);
    }

    public Vlog findVlogByAuthor(String name)
    {
        return this.vlogs.get(name);
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", vlogs=" + vlogs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Website website = (Website) o;
        return Objects.equals(name, website.name) &&
                Objects.equals(vlogs, website.vlogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vlogs);
    }
}

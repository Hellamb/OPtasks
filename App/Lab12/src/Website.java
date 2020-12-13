import java.util.HashMap;

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
}

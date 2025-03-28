package Task_3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String id;
    private String name;
    private final List<Fine> fines;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
        this.fines = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Fine> getFines() { return fines; }

    public void addFine(Fine fine) { fines.add(fine); }
    public boolean removeFine(Fine fine) { return fines.remove(fine); }

    @Override
    public String toString() {
        return "ID: " + id + ", Ім'я: " + name + ", Штрафи: " + fines;
    }
}
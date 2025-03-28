package Task_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TaxDatabase {
    private final Map<String, Person> database;

    public TaxDatabase() {
        database = new HashMap<>();
    }

    public void printAll() {
        database.values().forEach(System.out::println);
    }

    public void printById(String id) {
        Optional.ofNullable(database.get(id)).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Особа з ID " + id + " не знайдена.")
        );
    }

    public void printByFineType(String type) {
        database.values().forEach(person ->
                person.getFines().stream()
                        .filter(fine -> fine.getType().equals(type))
                        .forEach(fine -> System.out.println(person + " | " + fine))
        );
    }

    public void printByCity(String city) {
        database.values().forEach(person ->
                person.getFines().stream()
                        .filter(fine -> fine.getCity().equals(city))
                        .forEach(fine -> System.out.println(person + " | " + fine))
        );
    }

    public boolean addPerson(String id, String name) {
        if (!database.containsKey(id)) {
            database.put(id, new Person(id, name));
            return true;
        }
        return false;
    }

    public boolean addFine(String id, Fine fine) {
        return Optional.ofNullable(database.get(id)).map(person -> {
            person.addFine(fine);
            return true;
        }).orElse(false);
    }

    public boolean removeFine(String id, Fine fine) {
        return Optional.ofNullable(database.get(id)).map(person -> person.removeFine(fine))
                .orElse(false);
    }

    public boolean updatePerson(String id, String newName, List<Fine> newFines) {
        return Optional.ofNullable(database.get(id)).map(person -> {
            person.setName(newName);
            person.getFines().clear();
            person.getFines().addAll(newFines);
            return true;
        }).orElse(false);
    }

    public boolean removePerson(String id) {
        return database.remove(id) != null;
    }
}
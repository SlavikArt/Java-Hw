package Task_3;

public class Task_3 {
    public static void main(String[] args) {
        TaxDatabase db = new TaxDatabase();

        db.addPerson("001", "Андрій Шевченко");
        db.addPerson("002", "Олена Григорівна");
        db.addPerson("003", "Петро Васильович");
        db.addPerson("004", "Софія Марчук");

        db.addFine("001", new Fine("Перевищення швидкості", "Київ", 1200.0));
        db.addFine("001", new Fine("Неправильне паркування", "Вишгород", 450.0));
        db.addFine("002", new Fine("Проїзд на червоне", "Львів", 800.0));
        db.addFine("003", new Fine("Перевищення швидкості", "Одеса", 1500.0));
        db.addFine("003", new Fine("Паркування на тротуарі", "Одеса", 600.0));
        db.addFine("004", new Fine("Розмова по телефону", "Харків", 700.0));

        System.out.println("Повна база даних на початок:");
        db.printAll();

        System.out.println("\nШтрафи Андрія (ID 001):");
        db.printById("001");

        System.out.println("\nУсі штрафи за 'Перевищення швидкості':");
        db.printByFineType("Перевищення швидкості");

        System.out.println("\nШтрафи в місті 'Одеса':");
        db.printByCity("Одеса");

        System.out.println("\nОновлюємо дані Олени (ID 002):");
        db.updatePerson("002", "Олена Григорівна Коваленко", new java.util.ArrayList<>());
        db.addFine("002", new Fine("Непристебнутий ремінь", "Львів", 300.0));
        db.printById("002");

        System.out.println("\nВидаляємо сплачений штраф Петра (ID 003):");
        Fine fineToRemove = new Fine("Паркування на тротуарі", "Одеса", 600.0);
        db.removeFine("003", fineToRemove);
        db.printById("003");

        System.out.println("\nСпроба додати штраф для неіснуючого ID 005:");
        boolean added = db.addFine("005", new Fine("Перевищення швидкості", "Дніпро", 1300.0));
        System.out.println("Результат додавання: " + (added ? "Успішно" : "Невдача"));

        System.out.println("\nВидаляємо Софію (ID 004):");
        db.removePerson("004");
        System.out.println("База після видалення:");
        db.printAll();

        System.out.println("\nСпроба знайти видалену Софію (ID 004):");
        db.printById("004");

        System.out.println("\nДодаємо нового водія:");
        db.addPerson("005", "Максим Кравець");
        db.addFine("005", new Fine("Неправильний поворот", "Київ", 400.0));
        db.printById("005");
    }
}
import java.util.*;

public class Program {

    static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        boolean f = true;
        while (f) {
            System.out.println("Меню телефонной книги");
            System.out.println("==========================");
            System.out.println("1 - Добавить запись в телефонную книгу");
            System.out.println("2 - Найти контакт в телефонной книге");
            System.out.println("3 - Вывести контакты телефонной книги");
            System.out.println("0 - Завершение работы приложения");
            System.out.println("================================");
            System.out.print("Укажите номер задачи: ");
            int no = Integer.parseInt(scanner.nextLine());
            switch (no) {
                case 0:
                    f = false;
                    System.out.println("Завершение работы приложения! Всего хорошего!");
                    break;
                case 1:
                    addNamePhone();
                    break;
                case 2:
                    findName();
                    break;
                case 3:
                    getPhoneBook();
                    break;
                default:
                    System.out.println("Вы указали некорректный пункт меню!\nПовторите попытку ввода.");
                    System.out.println("Нажмите Enter, чтобы продолжить");
                    break;
            }
        }
    }
    static void addNamePhone() {
        System.out.println("Введите имя контакта: ");
        String name = scanner.nextLine();
        System.out.println("Введите номер телефона контакта: ");
        String phone = scanner.nextLine();
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(phone);
            phoneBook.put(name, list);
        }
        System.out.println("Новый контакт добавлен");
        System.out.println("Нажмите Enter, чтобы продолжить");
        scanner.nextLine();
    }
    static void findName() {
        System.out.println("Введите имя контакта: ");
        String name = scanner.nextLine();
        if (phoneBook.containsKey(name)) {
            System.out.println(phoneBook.get(name));
            System.out.println("Нажмите Enter, чтобы продолжить");
            scanner.nextLine();
        } else {
            System.out.println("Данного контакта нет в телефонной книге");
            System.out.println("Нажмите Enter, чтобы продолжить");
            scanner.nextLine();
        }
    }
    public static void getPhoneBook() {
        List<Map.Entry<String, ArrayList<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        for (Map.Entry<String, ArrayList<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Нажмите Enter, чтобы продолжить");
        scanner.nextLine();
    }
}

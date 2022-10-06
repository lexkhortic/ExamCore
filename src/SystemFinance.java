import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SystemFinance {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<>();
        User user = new User("Алексей", 1, new Wallet("PayPal",1000));
        users.add(user);
        
        showMenuSystemFinance(users);

    }

    public static void showMenuUsers(User user) throws IOException {
        System.out.println(
                        "1 - Посмотреть сумму кошелька\n" +
                        "2 - Отображение списка затрат(последние 3)\n" +
                        "3 - Отображение списка доходов(последние 3)\n" +
                        "4 - Добавление затрат\n" +
                        "5 - Добавление доходов\n" +
                        "0 - ВЫХОД");
        System.out.print("Выбирете действие: ");
        int choice = Integer.parseInt(reader.readLine());

        if (choice == 0) {
            System.out.println("Программа закрывается...");
        }
        while (choice != 0) {
            switch (choice) {
                case 1:
                    user.getWallet().totalSumWallet();
                    showMenuUsers(user);
                case 2:
                    user.getWallet().showLastCost();
                    showMenuUsers(user);
                case 3:
                    user.getWallet().showLastIncome();
                    showMenuUsers(user);
                case 4:
                    user.getWallet().addNewCost();
                    showMenuUsers(user);
                case 5:
                    user.getWallet().addNewIncome();
                    showMenuUsers(user);
                default:
                    System.out.println("Не верный ввод, пропробуйте заново");
                    showMenuUsers(user);
            }
        }
    }

    public static void showMenuSystemFinance(ArrayList<User> users) throws IOException {
        System.out.println(
                        "1 - Посмотреть пользователей\n" +
                        "2 - Выбор пользователя для работы\n" +
                        "0 - ВЫХОД");
        System.out.print("Выбирете действие: ");
        int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    users.forEach(System.out::println);
                    showMenuSystemFinance(users);
                    break;
                case 2:
                    System.out.print("Введите имя владельца кошелька: ");
                    users.forEach(user -> {
                        try {
                            if (user.getName().equals(reader.readLine())) {
                                showMenuUsers(user);
                            } else {
                                System.out.println("Пользователь не найден!");
                                showMenuSystemFinance(users);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    break;
                case 0:
                    System.out.println("Программа закрывается...");
                    return;
                default:
                    System.out.println("Не верный ввод, пропробуйте заново");
                    showMenuSystemFinance(users);
                    break;
        }
    }
}

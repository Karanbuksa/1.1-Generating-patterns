import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Integer> list = new ArrayList<>();


        logger.log("Запускаем программу");
        logger.log("Здороваемся");
        System.out.println("Здравствуйте!");
        logger.log("Просим пользователя ввести входные данные для списка");

        int N = inputInt(logger, scanner, 1);
        int M = inputInt(logger, scanner, 2);

        logger.log("Создаём и наполняем список");

        for (int i = 0; i < N - 1; i++) {
            list.add(random.nextInt(M));
        }

        System.out.println("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");

        int f = inputInt(logger, scanner, 3);
        Filter filter = new Filter(f);
        System.out.println("Отфильтрованный список: " + filter.filterOut(list).toString());
    }

    private static int inputInt(Logger logger, Scanner scanner, int modifier) {
        String Nstr;
        int N;
        String phrase1 = null;
        String phrase2 = null;
        switch (modifier) {
            case 1 -> {
                phrase1 = "Введите размер списка:";
                phrase2 = "размера списка";
            }
            case 2 -> {
                phrase1 = "Введите верхнюю границу для значений:";
                phrase2 = "верхней границы значений";
            }
            case 3 -> {
                phrase1 = "Введите порог для фильтра:";
                phrase2 = "фильтра";
            }
        }
        while (true) {
            System.out.print(phrase1);
            Nstr = scanner.nextLine();
            if (isNumber(Nstr)) {
                N = Integer.parseInt(Nstr);
                logger.log("Пользователь использовал верный формат данных для " + phrase2);
                break;
            } else {
                System.out.println("Введено не число, попробуйте ещё раз");
                logger.log("Пользователь использовал неверный формат данных для " + phrase2);
            }
        }
        return N;
    }


    public static boolean isNumber(String bet) {
        return Pattern.compile("^\\d+$").matcher(bet).matches();
    }
}

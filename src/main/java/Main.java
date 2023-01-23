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


        logger.log("��������� ���������");
        logger.log("�����������");
        System.out.println("������������!");
        logger.log("������ ������������ ������ ������� ������ ��� ������");

        int N = inputInt(logger, scanner, 1);
        int M = inputInt(logger, scanner, 2);

        logger.log("������ � ��������� ������");

        for (int i = 0; i < N - 1; i++) {
            list.add(random.nextInt(M));
        }

        System.out.println("��� ��������� ������: " + list);
        logger.log("������ ������������ ������ ������� ������ ��� ����������");

        int f = inputInt(logger, scanner, 3);
        Filter filter = new Filter(f);
        System.out.println("��������������� ������: " + filter.filterOut(list).toString());
    }

    private static int inputInt(Logger logger, Scanner scanner, int modifier) {
        String Nstr;
        int N;
        String phrase1 = null;
        String phrase2 = null;
        switch (modifier) {
            case 1 -> {
                phrase1 = "������� ������ ������:";
                phrase2 = "������� ������";
            }
            case 2 -> {
                phrase1 = "������� ������� ������� ��� ��������:";
                phrase2 = "������� ������� ��������";
            }
            case 3 -> {
                phrase1 = "������� ����� ��� �������:";
                phrase2 = "�������";
            }
        }
        while (true) {
            System.out.print(phrase1);
            Nstr = scanner.nextLine();
            if (isNumber(Nstr)) {
                N = Integer.parseInt(Nstr);
                logger.log("������������ ����������� ������ ������ ������ ��� " + phrase2);
                break;
            } else {
                System.out.println("������� �� �����, ���������� ��� ���");
                logger.log("������������ ����������� �������� ������ ������ ��� " + phrase2);
            }
        }
        return N;
    }


    public static boolean isNumber(String bet) {
        return Pattern.compile("^\\d+$").matcher(bet).matches();
    }
}

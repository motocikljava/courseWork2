import java.util.Scanner;

public class Main {
        public static void main(String[] args) {


            try (Scanner scanner = new Scanner(System.in)) {
                label:
                while (true) {
                    printMenu();
                    if (scanner.hasNextInt()) {
                        int menu = scanner.nextInt();
                        switch (menu) {
                            case 1:
                                Rabota.addZadacha(scanner);
                                break;
                            case 2:
                                Rabota.delZafacha(scanner);
                                break;
                            case 3:
                                Rabota.zadachaPeriod(scanner);
                                break;
                            case 4:
                                Rabota.spisok();
                                break label;
                        }
                    } else {
                        scanner.next();
                        System.out.println("Выберите пункт меню из списка!");
                    }
                }
            }
        }


        private static void printMenu() {
            System.out.println("1. Добавить задачу \n" +
                    "2. Удалить задачу \n" +
                    "3. Получить задачу на указанный день \n" +
                    "4. Вывести список задач \n" +
                    "0. Выход \n" +
                    "Выберите пункт меню: \n"
            );
        }
    }

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Rabota {
    public static HashMap<Integer, Zadacha> zadachaHashMap = new HashMap<>();
    public static HashMap<Integer, Zadacha> mestoZadach = new HashMap<>();

    public static void spisok() {
        Set<Zadacha> zadachaSet = new TreeSet<>(zadachaHashMap.values());


        System.out.println(zadachaSet);
    }


    //удаление задачи
    public static void delZafacha(Scanner scanner) {
        System.out.println(zadachaHashMap);

        System.out.println("Для удаления введите ID задачи: ");
        int delete = scanner.nextInt();

        mestoZadach.put(zadachaHashMap.get(delete).getId(), zadachaHashMap.get(delete));

        mestoZadach.get(delete).setDelete(true);
        mestoZadach.remove(delete);
    }

    final static DateTimeFormatter DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void zadachaPeriod(Scanner scanner) {

        String date = vvodData(scanner);
        LocalDateTime ldt = LocalDate.parse(date, Rabota.DATA).atStartOfDay();
        returnNextDate();
        for (Zadacha zadacha : zadachaHashMap.values()) {
            switch (zadacha.getRepeatability()) {
                case WEEKLY:
                    while (zadacha.getNextDate().isBefore(ldt)) {
                        zadacha.setNextDate
                                (zadacha.getNextDate().plusWeeks(1L));
                    }
                    break;

                case MONTHLY:
                    while (zadacha.getNextDate().isBefore(ldt)) {
                        zadacha.setNextDate
                                (zadacha.getNextDate().plusMonths(1L));
                    }
                    break;

                case YEARLY:
                    while (zadacha.getNextDate().isBefore(ldt)) {

                        zadacha.setNextDate
                                (zadacha.getNextDate().plusYears(1L));
                    }
                    break;
            }
        }
        ArrayList<Zadacha> zadachaArrayList = new ArrayList<>();
        for (Zadacha zadacha : zadachaHashMap.values()) {
            if (zadacha.getNextDate().format(Rabota.DATA).equals(date)) {
                zadachaArrayList.add(zadacha);
            }
            if (zadacha.getRepeatability() == EnRepeatability.DAILY) {
                zadachaArrayList.add(zadacha);
            }
            if (zadachaArrayList.isEmpty()) {
                System.out.println("пусто");
            }
            System.out.println(zadachaArrayList);


        }
    }

    // добаление задачи
    public static void addZadacha(Scanner scanner) {
        Zadacha zadacha = new Zadacha(
                inputTaskName(scanner),
                inputDescription(scanner),
                inputRepeatability(scanner),
                inputTypeTask(scanner));
        zadachaHashMap.put(zadacha.getId(), zadacha);
    }

    // выбор типа задачи
    public static boolean inputTypeTask(Scanner scanner) {
        System.out.println("Введите тип задачи \n" +
                "1- рабочая \n " +
                "2- личная \n ");
        int numTypeTask = scanner.nextInt();

        return valType(numTypeTask);
    }

    // выбор повторяемости
    private static EnRepeatability inputRepeatability(Scanner scanner) {

        System.out.println("Введите частоту повторяемости задачи \n" +
                "1 однократная \n" +
                "2- ежедневная \n" +
                "3- еженедельная \n" +
                "4- ежемесячная \n" +
                "5-ежегодная\n");
        int stringRepeatability = scanner.nextInt();
        if (stringRepeatability <= 0 && stringRepeatability > 2 ) {
            throw new RuntimeException("введите описание задачи");
        }

        return Repeatability(stringRepeatability);
    }

    // ввод описания задачи
    public static String inputDescription(Scanner scanner) {

        System.out.println("Введите описание задачи");
        String description = scanner.next();
        if (description == null || !description.isBlank() || !description.isEmpty()) {
            throw new RuntimeException("введите описание задачи");
        } else {
            return description;
        }

    }
    // ввод названия задачи

    private static String inputTaskName(Scanner scanner) {
try {
    System.out.println("Введите название задачи ");
    String taskName = scanner.next();
    return taskName;
}catch (Exception e){
    throw new RuntimeException(e);
}
    }



    //контроль типа задачи
    public static boolean valType(int v) {

        return v == 1;
    }


    //контроль выбор периодичности


    // ввод даты
    public static String vvodData(Scanner scanner) {
        System.out.println("Введите новую дату (дд.мм.гггг) ");
        return scanner.next();

    }
    //получениe следующей даты и времени выполнения.
    public static void returnNextDate() {

        for (Zadacha zadacha : zadachaHashMap.values()) {

            switch (zadacha.getRepeatability()) {
                case WEEKLY:
                    zadacha.setNextDate(zadacha.getNextDate().plusMonths(1L));
                    zadacha.getDateTask().plusWeeks(1L);
                    break;
                case MONTHLY:
                    zadacha.setNextDate(zadacha.getNextDate().plusMonths(1L));
                    zadacha.getDateTask().plusMonths(1L);
                    break;
                case YEARLY:
                    zadacha.setNextDate(zadacha.getNextDate().plusMonths(1L));
                    zadacha.getDateTask().plusYears(1L);
                    break;
            }
        }
    }
    public static EnRepeatability Repeatability(int s) {
        EnRepeatability repeatability = null;
        switch (s) {
            case 1:
                repeatability = EnRepeatability.ONCE;
                break;
            case 2:
                repeatability = EnRepeatability.DAILY;
                break;
            case 3:
                repeatability = EnRepeatability.WEEKLY;
                break;
            case 4:
                repeatability = EnRepeatability.MONTHLY;
                break;
            case 5:
                repeatability = EnRepeatability.YEARLY;
                break;
        }
        if (repeatability == null) {
            throw new RuntimeException("Повторяемость задачи введена неккоректно");
        } else {
            return repeatability;
        }

    }
}



//String tochka = data;
//        tochka = tochka.replaceAll("[\\p{Punct}]", "");
//        return tochka;
//String tochka = data;
//        tochka = tochka.replaceAll("[\\p{Punct}]", "");
//        return tochka;

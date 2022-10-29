import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static void inputTask(Scanner scanner, DailyPlanner dailyPlanner) throws EmptyStringValueException {
        System.out.print("Введите название задачи: ");
        String taskHeading = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        printMenuTaskType();
        System.out.print("Выберите тип задачи (нужный пункт меню): ");
        String taskType = null;
        if (scanner.hasNextInt()) {
            int menuTaskType = scanner.nextInt();
            switch (menuTaskType) {
                case 1:
                    taskType = "рабочая";
                    break;
                case 2:
                    taskType = "личная";
                    break;
                case 0:
                    break;
            }
        } else {
            scanner.next();
            System.out.println("Выберите пункт меню из списка!");
            return;
        }
        printMenuTaskRepeat();
        System.out.print("Выберите регулярность повтора задачи (нужный пункт меню): ");
        String taskRepeat;
        if (scanner.hasNextInt()) {
            int menuTaskRepeat = scanner.nextInt();
            switch (menuTaskRepeat) {
                case 1:
                    taskRepeat = "однократно";
                    Tasks task = new TasksSingle(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task);
                    break;
                case 2:
                    taskRepeat = "ежедневно";
                    Tasks task2 = new TasksDaily(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task2);
                    break;
                case 3:
                    taskRepeat = "еженедельно";
                    Tasks task3 = new TasksWeekly(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task3);
                    break;
                case 4:
                    taskRepeat = "ежемесячно";
                    Tasks task4 = new TasksMonthly(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task4);
                    break;
                case 5:
                    taskRepeat = "ежегодно";
                    Tasks task5 = new TasksYearly(taskHeading, taskDescription, taskType, taskRepeat);
                    dailyPlanner.addTaskToDailyPlanner(task5);
                    break;
                case 0:
                    break;
            }
        } else {
            scanner.next();
            System.out.println("Выберите пункт меню из списка!");
        }
    }

    private static void changeTask(Scanner scanner, DailyPlanner dailyPlanner) throws EmptyStringValueException {
        System.out.print("Введите номер задачи для изменения: ");
        Integer number = scanner.nextInt();
        System.out.print("Введите новое название задачи: ");
        String taskHeading = scanner.next();
        System.out.print("Введите новое описание задачи: ");
        String taskDescription = scanner.next();
        dailyPlanner.changeTaskHeadingAndDescription(number, taskHeading, taskDescription);
    }

    private static void deleteTask(Scanner scanner, DailyPlanner dailyPlanner) {
        System.out.print("Введите номер задачи для удаления: ");
        Integer number = scanner.nextInt();
        dailyPlanner.removeTaskToDailyPlanner(number);
    }

    private static void findTaskToDate(Scanner scanner, DailyPlanner dailyPlanner) throws InterruptedException {
        System.out.print("Сейчас нужно будет ввести дату. Сначала укажите год: ");
        int year = scanner.nextInt();
        System.out.print("Теперь укажите месяц: ");
        int month = scanner.nextInt();
        System.out.print("И укажите интересующий день: ");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        dailyPlanner.findTheNextTask(date);
    }

    private static void printMenu() {
        System.out.println(" 1. Добавить задачу ");
        System.out.println(" 2. Удалить задачу ");
        System.out.println(" 3. Получить задачу на указанный день ");
        System.out.println(" 4. Получить список всех задач ");
        System.out.println(" 7. Изменить название и/или описание задачи ");
        System.out.println(" 9. Получить список удалённых задач ");
        System.out.println(" 0. Выход ");
    }

    private static void printMenuTaskType() {
        System.out.println(" 1. рабочая ");
        System.out.println(" 2. личная ");
        System.out.println(" 0. Выход ");
    }

    private static void printMenuTaskRepeat() {
        System.out.println(" 1. однократно ");
        System.out.println(" 2. ежедневно ");
        System.out.println(" 3. еженедельно ");
        System.out.println(" 4. ежемесячно ");
        System.out.println(" 5. ежегодно ");
        System.out.println(" 0. Выход ");
    }

    public static void main(String[] args) throws EmptyStringValueException, InterruptedException {

        DailyPlanner dailyPlanner = new DailyPlanner();

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, dailyPlanner);
                            break;
                        case 2:
                            deleteTask(scanner, dailyPlanner);
                            break;
                        case 3:
                            findTaskToDate(scanner, dailyPlanner);
                            break;
                        case 4:
                            dailyPlanner.printAllTasks();
                            break;
                        case 7:
                            changeTask(scanner, dailyPlanner);
                            break;
                        case 9:
                            dailyPlanner.printDeletedTasks();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

}





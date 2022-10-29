import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DailyPlanner {

    private final Map<Integer, Tasks> dailyPlanner = new HashMap<>();

    public Map<Integer, Tasks> getDailyPlanner() {
        return dailyPlanner;
    }

    public void addTaskToDailyPlanner(Tasks task) {
        if (dailyPlanner.containsKey(task.getId())) {
            for (Map.Entry<Integer, Tasks> entry : dailyPlanner.entrySet()) {
                if (entry.getKey().equals(task.getId())) {
                    throw new RuntimeException("Задание с этим ключом уже есть в коллекции!");
                }
            }
        }
        dailyPlanner.put(task.getId(), task);
    }

    public void removeTaskToDailyPlanner(Integer key) {
        if (dailyPlanner.containsKey(key)) {
            for (Map.Entry<Integer, Tasks> entry : dailyPlanner.entrySet()) {
                if (entry.getKey().equals(key)) {
                    System.out.println("Задача с номером " + key + " успешно удалена.");
                    entry.getValue().setCheckDeleted(true);
                    return;
                }
            }
        }
        System.out.println("Задача с номером " + key + " не была найдена, удаление невозможно.");
    }

    public void changeTaskHeadingAndDescription(Integer key, String heading, String description) throws EmptyStringValueException {
        if (dailyPlanner.containsKey(key)) {
            for (Map.Entry<Integer, Tasks> entry : dailyPlanner.entrySet()) {
                if (entry.getKey().equals(key)) {
                    entry.getValue().setHeading(heading);
                    entry.getValue().setDescription(description);
                    return;
                }
            }
        }
        System.out.println("Задача с номером " + key + " не была найдена, изменение невозможно.");
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Tasks> entry : dailyPlanner.entrySet()) {
            if (!entry.getValue().isCheckDeleted()) {
                System.out.println(entry.getValue());
            }
        }
    }

    public void printDeletedTasks() {
        for (Map.Entry<Integer, Tasks> entry : dailyPlanner.entrySet()) {
            if (entry.getValue().isCheckDeleted()) {
                System.out.println(entry.getValue());
            }
        }
    }

    public void findTheNextTask(LocalDate date) throws InterruptedException {
        System.out.println("На дату " + date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth() +
                " запланированы следующие события: ");
        long start = System.nanoTime();
        for (Map.Entry<Integer, Tasks> entry : dailyPlanner.entrySet()) {
            while (entry.getValue().getDayCreation().isBefore(date) ||
                    entry.getValue().getDayCreation().isEqual(date)) {
                if (entry.getValue().getDayCreation().isEqual(date) && !entry.getValue().isCheckDeleted()) {
                    System.out.println(entry.getValue().getHeading());
                }
                entry.getValue().getNextDate();
            }
            entry.getValue().setDayCreation(entry.getValue().getDayToChange());
        }
        Thread.sleep(1000);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Для нахождения задач потребовалось времени, нс: " + elapsed);
    }

    @Override
    public String toString() {
        return "DailyPlanner{" +
                "dailyPlanner=" + getDailyPlanner() +
                '}';
    }
}

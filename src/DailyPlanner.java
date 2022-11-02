import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DailyPlanner {

    private final Map<Integer, Task> dailyPlanner = new HashMap<>();

    private final Map<Integer, Task> deletedTasks = new HashMap<>();

    public Map<Integer, Task> getDailyPlanner() {
        return dailyPlanner;
    }


    public void addTaskToDailyPlanner(Task task) {
        if (dailyPlanner.containsKey(task.getId())) {
            throw new RuntimeException("Задание с этим ключом уже есть в коллекции!");
        }
        dailyPlanner.put(task.getId(), task);
    }

    public void removeTaskToDailyPlanner(Integer key) {
        if (dailyPlanner.containsKey(key)) {
            System.out.println("Задача с номером " + key + " успешно удалена.");
            deletedTasks.put(key, getDailyPlanner().get(key));
            dailyPlanner.remove(key, getDailyPlanner().get(key));
            return;
        }
        System.out.println("Задача с номером " + key + " не была найдена, удаление невозможно.");
    }

    public void changeTaskHeadingAndDescription(Integer key, String heading, String description) throws EmptyStringValueException {
        if (dailyPlanner.containsKey(key)) {
            getDailyPlanner().get(key).setHeading(heading);
            getDailyPlanner().get(key).setDescription(description);
            return;
        }
        System.out.println("Задача с номером " + key + " не была найдена, изменение невозможно.");
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> entry : dailyPlanner.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void printDeletedTasks() {
        for (Map.Entry<Integer, Task> entry : deletedTasks.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void findTheNextTask(LocalDateTime date) {
        System.out.println("На дату " + date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth() +
                " запланированы следующие события: ");
        for (Map.Entry<Integer, Task> entry : dailyPlanner.entrySet()) {
            if (entry.getValue().appersIn(date)) {
                System.out.println(entry.getValue().getHeading() + " в " + entry.getValue().getDayCreation().getHour() +
                        " часов, " + entry.getValue().getDayCreation().getMinute() + " минут.");
            }
        }
    }

    @Override
    public String toString() {
        return "DailyPlanner{" +
                "dailyPlanner=" + getDailyPlanner() +
                '}';
    }
}

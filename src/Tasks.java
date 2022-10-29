import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Tasks {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final Integer id;
    private String heading;
    private String description;
    private String typeTask;
    private String repeat;
    private boolean checkDeleted;

    private LocalDate dayCreation;

    private final LocalDate dayToChange;

    public Tasks(String heading, String description, String typeTask, String repeat) throws EmptyStringValueException {
        id = COUNTER.getAndIncrement();
        setHeading(heading);
        this.description = description;
        setTypeTask(typeTask);
        setRepeat(repeat);
        this.dayCreation = LocalDate.now();
        this.dayToChange = LocalDate.now();
        setCheckDeleted(false);
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) throws EmptyStringValueException {
        if (heading == null || heading.isEmpty()) {
            throw new EmptyStringValueException("Не заполнено поле заголовок.");
        }
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(String typeTask) throws EmptyStringValueException {
        if (typeTask == null || typeTask.isEmpty()) {
            throw new EmptyStringValueException("Не заполнено поле тип задачи.");
        }
        this.typeTask = typeTask;
    }

    public LocalDate getDayCreation() {
        return dayCreation;
    }

    public LocalDate getDayToChange() {
        return dayToChange;
    }

    public void setDayCreation(LocalDate dayCreation) {
        this.dayCreation = dayCreation;
    }

    public String getRepeat() {
        return repeat;
    }

    public boolean isCheckDeleted() {
        return checkDeleted;
    }


    public void setCheckDeleted(boolean checkDeleted) {
        this.checkDeleted = checkDeleted;
    }

    public void setRepeat(String repeat) throws EmptyStringValueException {
        if (repeat == null || repeat.isEmpty()) {
            throw new EmptyStringValueException("Не заполнено поле тип задачи.");
        }
        this.repeat = repeat;
    }


    public abstract void getNextDate();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return checkDeleted == tasks.checkDeleted && id.equals(tasks.id) && Objects.equals(heading, tasks.heading) && Objects.equals(description, tasks.description) && Objects.equals(typeTask, tasks.typeTask) && Objects.equals(repeat, tasks.repeat) && Objects.equals(dayCreation, tasks.dayCreation) && Objects.equals(dayToChange, tasks.dayToChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heading, description, typeTask, repeat, checkDeleted, dayCreation, dayToChange);
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", repeat='" + getRepeat() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", typeTask='" + getTypeTask() + '\'' +
                ", dayCreation=" + dayCreation.getYear() + " " + dayCreation.getMonth() + " " + dayCreation.getDayOfMonth() +
                '}';
    }
}

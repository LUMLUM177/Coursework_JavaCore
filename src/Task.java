import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Task {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final Integer id;
    private String heading;
    private String description;
    private TypeTask typeTask;
    private Repeat repeat;
    private LocalDateTime dayCreation;

    public Task(String heading, String description, TypeTask typeTask, Repeat repeat, LocalDateTime date) throws EmptyStringValueException {
        id = COUNTER.getAndIncrement();
        setHeading(heading);
        this.description = description;
        setTypeTask(typeTask);
        setRepeat(repeat);
        this.dayCreation = date;
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

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) throws EmptyStringValueException {
        if (typeTask == null) {
            throw new EmptyStringValueException("Не заполнено поле тип задачи.");
        }
        this.typeTask = typeTask;
    }

    public LocalDateTime getDayCreation() {
        return dayCreation;
    }

    public void setDayCreation(LocalDateTime dayCreation) {
        this.dayCreation = dayCreation;
    }

    public Repeat getRepeat() {
        return repeat;
    }

    public void setRepeat(Repeat repeat) throws EmptyStringValueException {
        if (repeat == null) {
            throw new EmptyStringValueException("Не заполнено поле тип задачи.");
        }
        this.repeat = repeat;
    }


    public abstract boolean appersIn(LocalDateTime date);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task tasks = (Task) o;
        return id.equals(tasks.id) && Objects.equals(heading, tasks.heading) && Objects.equals(description, tasks.description) && Objects.equals(typeTask, tasks.typeTask) && Objects.equals(repeat, tasks.repeat) && Objects.equals(dayCreation, tasks.dayCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heading, description, typeTask, repeat, dayCreation);
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", repeat='" + getRepeat().getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", typeTask='" + getTypeTask().getName() + '\'' +
                ", dayCreation=" + dayCreation.getDayOfMonth() + " " + dayCreation.getMonth() + " " + dayCreation.getYear()
                + " " + dayCreation.getHour() + " " + dayCreation.getMinute() +
                '}';
    }
}

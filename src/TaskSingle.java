import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskSingle extends Task {

    public TaskSingle(String heading, String description, TypeTask typeTask, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, date);
    }


    @Override
    public boolean appersIn(LocalDateTime date) {
        boolean appearanceOnCurrentDate;
        LocalDate compareDate = date.toLocalDate();
        LocalDate compareDateTask = getDayCreation().toLocalDate();
        appearanceOnCurrentDate = compareDateTask.isEqual(compareDate);
        return appearanceOnCurrentDate;
    }
}

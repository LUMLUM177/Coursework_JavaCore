import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskWeekly extends Task {

    public TaskWeekly(String heading, String description, TypeTask typeTask, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, date);
    }

    @Override
    public boolean appersIn(LocalDateTime date) {
        boolean appearanceOnCurrentDate;
        LocalDate compareDate = date.toLocalDate();
        LocalDate compareDateTask = getDayCreation().toLocalDate();
        boolean equalOfDates = compareDateTask.isEqual(compareDate);
        appearanceOnCurrentDate = (getDayCreation().getDayOfWeek().equals(date.getDayOfWeek())) &&
                (getDayCreation().isBefore(date) || equalOfDates);
        return appearanceOnCurrentDate;
    }


}

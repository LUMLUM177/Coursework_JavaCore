import java.time.LocalDateTime;

public class TaskDaily extends Task {

    public TaskDaily(String heading, String description, TypeTask typeTask, Repeat repeat, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat, date);
    }

    @Override
    public boolean appersIn(LocalDateTime date) {
        boolean appearanceOnCurrentDate;
        boolean equalOfDates = getDayCreation().getDayOfMonth() == date.getDayOfMonth() &&
                getDayCreation().getMonthValue() == date.getMonthValue() &&
                getDayCreation().getYear() == date.getYear();
        appearanceOnCurrentDate = getDayCreation().isBefore(date) || equalOfDates;
        return appearanceOnCurrentDate;
    }
}

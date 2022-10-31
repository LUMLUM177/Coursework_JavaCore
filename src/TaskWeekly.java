import java.time.LocalDateTime;

public class TaskWeekly extends Task {

    public TaskWeekly(String heading, String description, TypeTask typeTask, Repeat repeat, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat, date);
    }

    @Override
    public boolean appersIn(LocalDateTime date) {
        boolean appearanceOnCurrentDate;
        boolean equalOfDates = getDayCreation().getDayOfMonth() == date.getDayOfMonth() &&
                getDayCreation().getMonthValue() == date.getMonthValue() &&
                getDayCreation().getYear() == date.getYear();
        appearanceOnCurrentDate = (getDayCreation().getDayOfWeek().equals(date.getDayOfWeek())) &&
                (getDayCreation().isBefore(date) || equalOfDates);
        return appearanceOnCurrentDate;
    }


}

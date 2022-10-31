import java.time.LocalDateTime;

public class TaskSingle extends Task {

    public TaskSingle(String heading, String description, TypeTask typeTask, Repeat repeat, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat, date);
    }


    @Override
    public boolean appersIn(LocalDateTime date) {
        boolean appearanceOnCurrentDate;
        appearanceOnCurrentDate = getDayCreation().getDayOfMonth() == date.getDayOfMonth() &&
                getDayCreation().getMonthValue() == date.getMonthValue() &&
                getDayCreation().getYear() == date.getYear();
        return appearanceOnCurrentDate;
    }
}

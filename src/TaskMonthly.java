import java.time.LocalDateTime;

public class TaskMonthly extends Task {

    public TaskMonthly(String heading, String description, TypeTask typeTask, Repeat repeat, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat, date);
    }

    @Override
    public boolean appersIn(LocalDateTime date) {
        boolean appearanceOnCurrentDate;
        LocalDateTime dateToChange = getDayCreation();
        boolean equalOfDates = getDayCreation().getDayOfMonth() == date.getDayOfMonth() &&
                getDayCreation().getMonthValue() == date.getMonthValue() &&
                getDayCreation().getYear() == date.getYear();
        boolean monthFebruary = date.getMonthValue() == 2;
        boolean monthNotFull = date.getMonthValue() == 4 || date.getMonthValue() == 6 ||
                date.getMonthValue() == 9 || date.getMonthValue() == 11;
        if (monthFebruary && getDayCreation().getDayOfMonth() >= 29) {
            setDayCreation(dateToChange.minusDays(3));
        }
        if (monthNotFull && getDayCreation().getDayOfMonth() == 31) {
            setDayCreation(dateToChange.minusDays(1));
        }
        appearanceOnCurrentDate = (getDayCreation().getDayOfMonth() == date.getDayOfMonth()) &&
                (getDayCreation().isBefore(date) || equalOfDates);

        setDayCreation(dateToChange);
        return appearanceOnCurrentDate;
    }
}

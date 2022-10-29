
public class TasksMonthly extends Tasks {

    public TasksMonthly(String heading, String description, String typeTask, String repeat) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setDayCreation(getDayCreation().plusMonths(1));
    }
}

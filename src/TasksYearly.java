
public class TasksYearly extends Tasks {

    public TasksYearly(String heading, String description, String typeTask, String repeat) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setDayCreation(getDayCreation().plusYears(1));
    }
}


public class TasksWeekly extends Tasks {

    public TasksWeekly(String heading, String description, String typeTask, String repeat) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setDayCreation(getDayCreation().plusDays(7));
    }


}

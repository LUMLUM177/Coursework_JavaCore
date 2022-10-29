public class TasksDaily extends Tasks {

    public TasksDaily(String heading, String description, String typeTask, String repeat) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setDayCreation(getDayCreation().plusDays(1));
    }
}

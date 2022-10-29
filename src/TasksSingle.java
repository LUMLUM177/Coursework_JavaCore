public class TasksSingle extends Tasks {

    public TasksSingle(String heading, String description, String typeTask, String repeat) throws EmptyStringValueException {
        super(heading, description, typeTask, repeat);
    }

    @Override
    public void getNextDate() {
        setDayCreation(getDayCreation().plusDays(Integer.MAX_VALUE));
    }
}

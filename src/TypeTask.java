public enum TypeTask {

    personal ("личная"),
    working ("рабочая");

    private final String name;

    TypeTask (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

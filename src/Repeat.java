public enum Repeat {

    once ("однократно"),
    daily ("ежедневно"),
    weekly ("еженедельно"),
    monthly ("ежемесячно"),
    yearly ("ежегодно");


    private final String name;

    Repeat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

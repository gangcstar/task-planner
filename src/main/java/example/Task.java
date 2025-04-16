package example;

public class Task {
    protected int id;
    protected String name;
    protected String description;
    protected Status status;

    public Task(int id, String name, String description, Status status) {
        this.id = id;
        this.name= name;
        this.description = description;
        this.status = status;
    }

    public int getId() {return id;}

    public String getName() {return name;}

    public String getDescription() {return description;}

    public Status getStatus() {return status;}


    @Override
    public String toString() {
        return "Task" +
                "id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", status=" + status;
    }

}

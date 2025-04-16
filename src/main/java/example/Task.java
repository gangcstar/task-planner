package example;

public class Task {
    private int id;
    private String name;
    private String description;
    private Status status;

    public Task(int id, String name, String description, Status status) {
        this.id = id;
        this.name= name;
        this.description = description;
        this.status = status;
    }

    public getId() {return id;}

    public getName() {return name;}

    public getDescription() {return description;}

    public Status getStatus() {return status;}

}

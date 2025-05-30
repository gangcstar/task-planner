package example.model;

import example.util.Identifier;
import example.util.Status;

public class Task {
    protected int id;
    protected String name;
    protected String description;
    protected Status status;

    public Task(String name, String description) {
        this.id = Identifier.INSTANCE.generate();
        this.name= name;
        this.description = description;
        this.status = Status.NEW;
    }

    public int getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task" +
                "id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", status=" + status;
    }

}

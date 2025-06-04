package example.model;

import example.util.Status;

public class Subtask extends Task {
    //private int epicId;
    private Epic epic;

    public Subtask(String name, String description, Epic epic) {
        super(name, description);
        this.epic = epic;
    }

    public Status getStatus() {
        return status;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
            epic.updateStatus();
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public String toString() {
        return "Subtask" +
                "id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", epic = " + epic.getId() +
                ", Status = " + status;
    }

}

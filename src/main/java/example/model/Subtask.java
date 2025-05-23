package example.model;

import example.util.Status;

public class Subtask extends Task {
    private int epicId;
    private Epic epic;

    public Subtask(String name, String description, int epicId) {
        super(name, description);
        this.epicId = epicId;
    }

    public Status getStatus() {
        return status;
    }

    public int getEpicId() {
        return epicId;
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
                ", epicId = " + epicId +
                ", Status = " + status;
    }

}

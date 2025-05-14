package example.model;

import example.util.Identifier;
import example.util.Status;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Subtask> subtasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public List<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks);
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
        updateStatus();
    }

    public void removeSubtask(Subtask subtask) {
        subtasks.remove(subtask);
        updateStatus();
    }

    public void updateStatus() {
        if (subtasks.isEmpty()) {
            setStatus(Status.NEW);
            return;
        }

        int newCount = 0;
        int doneCount = 0;

        for (Subtask subtask : subtasks) {
            Status status = subtask.getStatus();
            if (status == Status.NEW) {
                newCount++;
            } else if (status == Status.DONE) {
                doneCount++;
            }
        }

        if (newCount == subtasks.size()) {
            setStatus(Status.NEW);
        } else if (doneCount == subtasks.size()) {
            setStatus(Status.DONE);
        } else {
            setStatus(Status.IN_PROGRESS);
        }
    }

    @Override
    public String toString() {
        return "Epic" +
                "id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", status=" + status +
                ", subTasks = " + subtasks;
    }

}
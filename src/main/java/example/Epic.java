package example;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subTaskIds;

    public Epic(int id, String name, String description) {
        super(id, name, description, Status.NEW);
        this.subTaskIds = new ArrayList<>();
    }

    public List<Integer> getSubTaskIds() {return subTaskIds;}

    public void addSubTaskId(int subTaskId) {
        subTaskIds.add(subTaskId);
    }

    public void removeSubTaskId(int subTaskId) {
        subTaskIds.remove(Integer.valueOf(subTaskId));
    }

    @Override
    public String toString() {
        return "Epic" +
                "id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", status=" + status +
                ", subTaskIds = " + subTaskIds;
    }

}

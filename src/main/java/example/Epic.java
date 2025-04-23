package example;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subtaskIds = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    public void addSubtaskId(int id) {
        subtaskIds.add(id);
    }

    public void removeSubtasksId(int id) {
        subtaskIds.remove(Integer.valueOf(id));
    }
    @Override
    public String toString() {
        return "Epic" +
                "id = " + id +
                ", name = " + name +
                ", description = " + description +
                ", status=" + status +
                ", subTaskIds = " + subtaskIds;
    }

}
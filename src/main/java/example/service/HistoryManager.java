package example.service;

import example.model.Task;
import java.util.List;

public interface HistoryManager {
    void add(Task task);

    List<Task> getHistory();
}

package example.service;

import example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{

    private static final List<Task> history = new ArrayList<>(10);
    @Override
    public void add(Task task) {
        history.add(task);
    }

    @Override
    public List<Task> getHistory() {
            List<Task> result = new ArrayList<>();
            for (Task task : history) {
                result.add(task);
            }
            return result;
        }

}
